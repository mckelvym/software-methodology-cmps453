// Class    : CMPS 453
// Section  : 001
// Problem  : Adapter Programming Assignment
// Name     : McKelvy, James Markus
// CLID     : jmm0468

//  --* Certification of Authenticity *--
//  I certify that this assignment is entirely my own work,
//  with the exception of the files provided for the project
//  from the teacher.

/**
 * Set of functions for acting on the StackStruct class, ported from C. Since
 * Java has no concept of "free" functions, these functions were placed in a
 * class and made static, so they behave and are used like free functions.
 */
public class StackUtils
{
	/**
	 * Destroys a StackStruct (not really necessary in Java).
	 */
	public static void cleanUp(StackStruct s)
	{
		s = null;
	}

	/**
	 * Creates a new StackStruct
	 */
	public static void initialize(final StackStruct s, final int size)
	{
		s.array = new int[size];
		s.size = size;
		s.sp = 0;
	}

	/**
	 * Returns true if input StackStruct is empty.
	 */
	public static boolean isEmpty(final StackStruct s)
	{
		return s.sp == 0;
	}

	/**
	 * Returns true if input StackStruct is full.
	 */
	public static boolean isFull(final StackStruct s)
	{
		return s.sp == s.size;
	}

	/**
	 * Removes an item from the top of the stack.
	 */
	public static int pop(final StackStruct s)
	{
		if (isEmpty(s))
		{
			return 0;
		}
		else
		{
			return s.array[--s.sp];
		}
	}

	/**
	 * Adds an item to the top of the stack.
	 */
	public static void push(final StackStruct s, final int item)
	{
		if (!isFull(s))
		{
			s.array[s.sp++] = item;
		}
	}
}
