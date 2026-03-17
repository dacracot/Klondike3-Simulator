package org.dacracot.util;
//---------------------------------------------------
@SuppressWarnings("unchecked")
public class TypedArray<T> {
	//-----------------------------------------------
	private T[] array;
	//-----------------------------------------------
	public TypedArray(int size) {
		array = (T[]) new Object[size];
		}
	//-----------------------------------------------
	public void add(int index, T value) {
		array[index] = value;
		}
	//-----------------------------------------------
	public T get(int index) {
		return array[index];
		}
	//-----------------------------------------------
}
//-----------------------------------------------
