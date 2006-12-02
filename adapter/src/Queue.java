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
 * Provides basic Queue operations.
 */
public class Queue
{
	/**
	 * @param args
	 */
	public static void main(final String[] args)
	{
		final Queue queue = new Queue(15);

		for (int i = 0; i < 25; i++)
		{
			queue.enque(i);
		}

		while (!queue.isEmpty())
		{
			System.out.print(queue.deque() + " ");
		}
	}

	// private stack member
	private final StackStruct	stack	= new StackStruct();

	/**
	 * Creates this, with an initial size.
	 * 
	 * @param size
	 *            size of queue to create.
	 */
	public Queue(final int size)
	{
		StackUtils.initialize(stack, size);
	}

	/**
	 * Removes and item from the beginning of this queue.
	 * 
	 * @return item at front of this queue.
	 */
	public int deque()
	{
		// create temp
		final StackStruct temp = new StackStruct();
		// create variable to hold popped item
		int popitem;
		// initialize temp stack
		StackUtils.initialize(temp, stack.sp);
		// copy all data to the temp stack
		// so we can get what is on the bottom
		do
		{
			popitem = StackUtils.pop(stack);
			if (!StackUtils.isEmpty(stack))
			{
				StackUtils.push(temp, popitem);
			}
		}
		while (!StackUtils.isEmpty(stack));

		// copy everything back to the private stack
		while (!StackUtils.isEmpty(temp))
		{
			StackUtils.push(stack, StackUtils.pop(temp));
		}

		return popitem;
	}

	/**
	 * Adds an item to the end of this queue.
	 * 
	 * @param item
	 *            item to add.
	 */
	public void enque(final int item)
	{
		// this is basically mapped to the push of stack
		StackUtils.push(stack, item);
	}

	/**
	 * Determines whether this queue is empty.
	 * 
	 * @return true if empty, false otherwise.
	 */
	public boolean isEmpty()
	{
		return StackUtils.isEmpty(stack);
	}

	/**
	 * Determines whether this queue is full.
	 * 
	 * @return true if full, false otherwise.
	 */
	public boolean isFull()
	{
		return StackUtils.isFull(stack);
	}
}
