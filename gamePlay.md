## Game play...

Description of the game play strategy currently in use.

---

# Deep Call Graph Analysis

The solver's execution graph is much more interesting than the high-level diagram suggests. The actual call hierarchy looks roughly like this:

```mermaid
flowchart TD

    A[Solitaire.main] --> B[Parse CLI Arguments]
    B --> C[Initialize Global State]
    C --> D[Game Loop]

    D --> E[Player.play]

    E --> F[new Klondike]
    E --> G[playNormal]

    G --> H[FromDeck.toFoundation]
    G --> I[FromTableau.toTableau]
    G --> J[FromTableau.toFoundation]
    G --> K[FromDeck.toTableau]
    G --> L[Deck.flip]

    H --> H1[Deck.getUpCard]
    H --> H2[Foundation.playCard]
    H2 --> H3[Deck.removeUpCard]

    I --> I1[Tableau.getUpCardsFromBottom]
    I --> I2[Tableau.getUpCardsFromTop]
    I --> I3[Sort longest columns first]
    I3 --> I4[playKingFromTableau]
    I3 --> I5[playCard bottom/top]

    J --> J1[Tableau.getUpCardsFromBottom]
    J --> J2[Sort shortest columns first]
    J2 --> J3[Foundation.playCard]
    J3 --> J4[Tableau.removeCard]

    K --> K1[Deck.getUpCard]
    K1 --> K2[playKingFromDeck]
    K1 --> K3[Tableau.playCard]
    K2 --> K4[Deck.removeUpCard]
    K3 --> K4

    G --> M{Foundation.winner}

    M -->|No| N[playRescue]
    M -->|Yes| O[Global.win]

    N --> P[FromFoundation.toTableau]

    P --> P1[Foundation.getUpCardsFromBottom]
    P --> P2[Tableau.getUpCardsFromBottom]
    P --> P3[Sort longest foundation first]
    P3 --> P4[Tableau.returnCard]
    P4 --> P5[Foundation.removeCard]

    N --> Q[FromTableau.toTableau]
    N --> R[FromDeck.toTableau]

    N --> S{Rescue moved cards}
    S -->|Yes| G
    S -->|No| T[Loss]

    O --> U[Statistics]
    T --> U
```

## Actual Solver Decision Tree

The heart of the application is `Player.playNormal()`.

Every iteration executes in this exact order:

```text
1. Deck      -> Foundation
2. Tableau   -> Tableau (repeat until exhausted)
3. Tableau   -> Foundation
4. Deck      -> Tableau (repeat until exhausted)
5. Flip Stock
```

This is not merely a move list—it defines the entire search strategy.

---

## Tableau-to-Tableau Heuristic

Your strongest heuristic is here:

```java
Collections.sort(topUpCards, CardColumnLengthDescending);
```

This means:

```text
Candidate Moves
    ↓
Choose source column
    ↓
Longest column first
    ↓
Attempt move
```

Conceptually:

```text
Move Available?
│
├─ No
│   └─ Continue Search
│
└─ Yes
    │
    ├─ Exposes hidden card?
    │     └─ Highest Priority
    │
    └─ Otherwise
          First legal move
```

Hidden-card exposure is currently the dominant factor in solver success.

---

## Rescue Phase Graph

The new rescue phase behaves like a second search engine.

```text
Normal Play Fails
        │
        ▼
Return Foundation Card
        │
        ▼
Tableau → Tableau Exhaustively
        │
        ▼
Deck → Tableau Exhaustively
        │
        ▼
More Foundation Cards Available?
        │
 ┌──────┴──────┐
 │             │
Yes           No
 │             │
 ▼             ▼
Repeat     Resume Normal Play
```

Limited backtracking without undoing the whole game state.

---

## Foundation Return Logic

`FromFoundation.toTableau()`

```text
Foundation Cards
       │
       ▼
Sort Longest Foundation First
       │
       ▼
Find Tableau Target
       │
       ▼
Legal Return?
       │
 ┌─────┴─────┐
 │           │
No          Yes
 │           │
 ▼           ▼
Next Card  Remove From Foundation
                │
                ▼
           Return Success
```

Prioritizes dismantling the most advanced foundation pile first.

---

## Most Important Observation

The solver is not a pure greedy solver, instead it effectively implements:

```text
Greedy Search
      +
Limited Backtracking
      +
Hidden-Card Exposure Bias
```

The rescue phase converts the algorithm from:

```text
Single-path search
```

into:

```text
Search
    ↓
Dead End
    ↓
Partial Rollback
    ↓
Continue Search
```

which accounts for the larger winning percentage than common heuristic tweaks.
