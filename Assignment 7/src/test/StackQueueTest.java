package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import asg7.QueueList;
import asg7.QueueListImpl;
import asg7.StackList;
import asg7.StackListImpl;
import asg7.StackListImpl;
import utils.MyUtils;

import java.util.StringTokenizer;
class StackQueueTest {
	final int OVER_LARGEST = 100009;
	String sName="";
	@Test
	public void test() {
		sName = utils.MyUtils.getNameFromStudent();
		MyUtils.printTimeStamp("begins");
		stackLinkedListTest();
		//stackArrayListTest();
		System.out.println("SUCCESS Stack Testing for " + sName + " complete.");
		queueTest();
		System.out.println("SUCCESS Queue Testing for " + sName + " complete.");
		MyUtils.printTimeStamp("ends");
	}

	public void stackLinkedListTest()
	{
		
		final int OVER_LARGEST = 100009;
		String pushString="";
		int pushInt = 0;
		StackList <String> s1 = new StackListImpl<String>(3);
		StackList<Integer> s2 = new StackListImpl<Integer>(2);
		StackList<String> s3 = new StackListImpl<String>();
		StackList<String> s4 = new StackListImpl<String>(-2);
		StackList<String> s5 = new StackListImpl<String>(StackList.LARGEST);
		StackList<String> s6 = new StackListImpl<String>(OVER_LARGEST);
		assertTrue(s5.getMaxSize()==StackList.LARGEST);
		assertTrue(s6.getMaxSize() == StackList.DEFAULT_MAX_SIZE);
		assertTrue(s4.getMaxSize() == StackList.DEFAULT_MAX_SIZE);
		assertTrue(s3.getMaxSize()==StackList.DEFAULT_MAX_SIZE);
		assertTrue(s1.getMaxSize()==3);
		assertTrue(s2.getMaxSize()==2);
		assertTrue(s1.isEmpty());
		assertTrue(s2.isEmpty());
		pushString="first";
		s1.push(pushString);
		assertTrue(s1.peek().equals(pushString));
		assertTrue(s1.getSize() == 1);
		assertTrue(!s1.isFull());
		assertTrue(!s1.isEmpty());
		pushString="second";
		s1.push(pushString);
		assertTrue(s1.peek().equals(pushString));
		assertTrue(s1.getSize() == 2);
		assertTrue(!s1.isFull());
		assertTrue(!s1.isEmpty());
		pushString="third";
		s1.push(pushString);
		assertTrue(s1.peek().equals(pushString));
		assertTrue(s1.getSize() == 3);
		assertTrue(s1.isFull());
		assertTrue(!s1.isEmpty());
		pushString="fourth";
		try {
			s1.push(pushString);
			System.out.println("FAILURE, push should throw a RuntimeException on a full stack");
		}catch(RuntimeException e) 
		{
			System.out.println("SUCCESS, push should throw a RuntimeException on a full stack\n" + e);
		}
		// new test toString()
		String str = s1.toString();
		StringTokenizer tokenizer = new StringTokenizer(str,"\n");
		String token = tokenizer.nextToken();
		assertTrue(token.equals("third"));
		token = tokenizer.nextToken();
		assertTrue(token.equals("second"));
		token = tokenizer.nextToken();
		assertTrue(token.equals("first"));
		assertEquals(3, utils.MyUtils.numberLines(str));
		System.out.println("*****\ntoString() of s1: \n" + str + "*****");
		assertTrue(s1.pop().equals("third"));
		assertTrue(s1.pop().equals("second"));
		assertTrue(s1.pop().equals("first"));
		assertTrue(s1.isEmpty());
		assertTrue(s1.getSize()==0);
		try {
			s1.pop();
			
			System.out.println("FAILURE, pop should throw a RuntimeException on an empty stack");
		}catch (RuntimeException e) 
		{
			System.out.println("SUCCESS, pop throws a RuntimeException on an empty stack\n" + e);
		}
		pushString="one";
		s1.push(pushString);
		assertTrue(s1.getSize() ==1);
		assertTrue(s1.pop().equals(pushString));
		assertTrue(s1.getSize() ==0 );
		assertTrue(s1.isEmpty());
		assertFalse(s1.isFull());
		
	    // now test Stack of Integer
		System.out.println("****  Now testing Stack<Integer>****");
		pushInt=1;
		s2.push(pushInt);
		assertTrue(s2.peek()==(pushInt));
		assertTrue(s2.getSize() == 1);
		assertTrue(!s2.isFull());
		assertTrue(!s2.isEmpty());
		pushInt = 2;
		s2.push(pushInt);
		assertTrue(s2.peek()==(pushInt));
		assertTrue(s2.getSize() == 2);
		assertTrue(s2.isFull());
		assertTrue(!s2.isEmpty());
		pushInt = 3;
		try {
			s2.push(pushInt);
			System.out.println("FAILURE, push should throw a RuntimeException on a full stack");
		}catch(RuntimeException e) 
		{
			System.out.println("SUCCESS, push should throw a RuntimeException on a full stack\n" + e);
		}
		assertTrue(s2.pop() == 2);
		assertTrue(s2.pop()==1);
		assertTrue(s2.isEmpty());
		assertTrue(s2.getSize()==0);
		try {
			s2.pop();
			
			System.out.println("FAILURE, pop should throw a RuntimeException on an empty stack");
			assertFalse(true);
		}catch (RuntimeException e) 
		{
			System.out.println("SUCCESS, pop throws a RuntimeException on an empty stack\n" + e);
		}
		try {
			s2.peek();
			
			System.out.println("FAILURE, peek should throw a RuntimeException on an empty stack");
			assertFalse(true);
		}catch (RuntimeException e) 
		{
			System.out.println("SUCCESS, peek throws a RuntimeException on an empty stack\n" + e);
		}
		s2.clear();
	    assertTrue(s2.getSize() == 0);
	    s2.clear();
	    assertTrue(s2.getSize() == 0);
	    pushInt=1;
		s2.push(pushInt);
		assertTrue(s2.peek()==(pushInt));
		assertTrue(s2.getSize() == 1);
		assertTrue(!s2.isFull());
		assertTrue(!s2.isEmpty());
		assertTrue(s2.getSize() ==1);
		assertTrue(s2.pop() == pushInt);
		assertTrue(s1.getSize() ==0 );
		assertTrue(s1.isEmpty());
		assertFalse(s1.isFull());
		s2.clear();
	    assertTrue(s2.getSize() == 0);
	    pushInt = 1;
	    s2.push(pushInt);
	    pushInt = 2;
	    s2.push(pushInt);
	    String retStr = s2.toString();
	    int numLines = utils.MyUtils.numberLines(retStr);
	    assertEquals(2,numLines);
	    s2.clear();
	    retStr = s2.toString();
	    numLines = utils.MyUtils.numberLines(retStr);
	    assertEquals(0,numLines);
	    s2.push(pushInt);
	    pushInt = 2;
	    s2.push(pushInt);
	    retStr = s2.toString();
	    numLines = utils.MyUtils.numberLines(retStr);
	    assertEquals(2,numLines);
	    
		System.out.println("SUCCESS StackTesting PASSES");
	    s2.clear();
	    assertTrue(s2.getSize() == 0);
	    assertTrue(s2.getMaxSize() == 2);
	    s2.clear();
	    assertTrue(s2.getSize() == 0);
	    assertTrue(s2.getMaxSize() == 2);
	}
		
	public void stackArrayListTest()
	{
		
		final int OVER_LARGEST = 100009;
		String pushString="";
		int pushInt = 0;
		StackList <String> s1 = new StackListImpl<String>(3);
		StackList<Integer> s2 = new StackListImpl<Integer>(2);
		StackList<String> s3 = new StackListImpl<String>();
		StackList<String> s4 = new StackListImpl<String>(-2);
		StackList<String> s5 = new StackListImpl<String>(StackList.LARGEST);
		StackList<String> s6 = new StackListImpl<String>(OVER_LARGEST);
		assertTrue(s5.getMaxSize()==StackList.LARGEST);
		assertTrue(s6.getMaxSize() == StackList.DEFAULT_MAX_SIZE);
		assertTrue(s4.getMaxSize() == StackList.DEFAULT_MAX_SIZE);
		assertTrue(s3.getMaxSize()==StackList.DEFAULT_MAX_SIZE);
		assertTrue(s1.getMaxSize()==3);
		assertTrue(s2.getMaxSize()==2);
		assertTrue(s1.isEmpty());
		assertTrue(s2.isEmpty());
		pushString="first";
		s1.push(pushString);
		assertTrue(s1.peek().equals(pushString));
		assertTrue(s1.getSize() == 1);
		assertTrue(!s1.isFull());
		assertTrue(!s1.isEmpty());
		pushString="second";
		s1.push(pushString);
		assertTrue(s1.peek().equals(pushString));
		assertTrue(s1.getSize() == 2);
		assertTrue(!s1.isFull());
		assertTrue(!s1.isEmpty());
		pushString="third";
		s1.push(pushString);
		assertTrue(s1.peek().equals(pushString));
		assertTrue(s1.getSize() == 3);
		assertTrue(s1.isFull());
		assertTrue(!s1.isEmpty());
		pushString="fourth";
		try {
			s1.push(pushString);
			System.out.println("FAILURE, push should throw a RuntimeException on a full stack");
		}catch(RuntimeException e) 
		{
			System.out.println("SUCCESS, push should throw a RuntimeException on a full stack\n" + e);
		}
		// new test toString()
		String str = s1.toString();
		StringTokenizer tokenizer = new StringTokenizer(str,"\n");
		String token = tokenizer.nextToken();
		assertTrue(token.equals("third"));
		token = tokenizer.nextToken();
		assertTrue(token.equals("second"));
		token = tokenizer.nextToken();
		assertTrue(token.equals("first"));
		assertEquals(3, utils.MyUtils.numberLines(str));
		System.out.println("*****\ntoString() of s1: \n" + str + "*****");
		assertTrue(s1.pop().equals("third"));
		assertTrue(s1.pop().equals("second"));
		assertTrue(s1.pop().equals("first"));
		assertTrue(s1.isEmpty());
		assertTrue(s1.getSize()==0);
		try {
			s1.pop();
			
			System.out.println("FAILURE, pop should throw a RuntimeException on an empty stack");
		}catch (RuntimeException e) 
		{
			System.out.println("SUCCESS, pop throws a RuntimeException on an empty stack\n" + e);
		}
		pushString="one";
		s1.push(pushString);
		assertTrue(s1.getSize() ==1);
		assertTrue(s1.pop().equals(pushString));
		assertTrue(s1.getSize() ==0 );
		assertTrue(s1.isEmpty());
		assertFalse(s1.isFull());
		
	    // now test Stack of Integer
		System.out.println("****  Now testing Stack<Integer>****");
		pushInt=1;
		s2.push(pushInt);
		assertTrue(s2.peek()==(pushInt));
		assertTrue(s2.getSize() == 1);
		assertTrue(!s2.isFull());
		assertTrue(!s2.isEmpty());
		pushInt = 2;
		s2.push(pushInt);
		assertTrue(s2.peek()==(pushInt));
		assertTrue(s2.getSize() == 2);
		assertTrue(s2.isFull());
		assertTrue(!s2.isEmpty());
		pushInt = 3;
		try {
			s2.push(pushInt);
			System.out.println("FAILURE, push should throw a RuntimeException on a full stack");
		}catch(RuntimeException e) 
		{
			System.out.println("SUCCESS, push should throw a RuntimeException on a full stack\n" + e);
		}
		assertTrue(s2.pop() == 2);
		assertTrue(s2.pop()==1);
		assertTrue(s2.isEmpty());
		assertTrue(s2.getSize()==0);
		try {
			s2.pop();
			
			System.out.println("FAILURE, pop should throw a RuntimeException on an empty stack");
			assertFalse(true);
		}catch (RuntimeException e) 
		{
			System.out.println("SUCCESS, pop throws a RuntimeException on an empty stack\n" + e);
		}
		try {
			s2.peek();
			
			System.out.println("FAILURE, peek should throw a RuntimeException on an empty stack");
			assertFalse(true);
		}catch (RuntimeException e) 
		{
			System.out.println("SUCCESS, peek throws a RuntimeException on an empty stack\n" + e);
		}
		s2.clear();
	    assertTrue(s2.getSize() == 0);
	    s2.clear();
	    assertTrue(s2.getSize() == 0);
	    pushInt=1;
		s2.push(pushInt);
		assertTrue(s2.peek()==(pushInt));
		assertTrue(s2.getSize() == 1);
		assertTrue(!s2.isFull());
		assertTrue(!s2.isEmpty());
		assertTrue(s2.getSize() ==1);
		assertTrue(s2.pop() == pushInt);
		assertTrue(s1.getSize() ==0 );
		assertTrue(s1.isEmpty());
		assertFalse(s1.isFull());
		s2.clear();
	    assertTrue(s2.getSize() == 0);
		System.out.println("SUCCESS StackTesting PASSES");
	    s2.clear();
	    assertTrue(s2.getSize() == 0);
	    assertTrue(s2.getMaxSize() == 2);
	    s2.clear();
	    assertTrue(s2.getSize() == 0);
	    assertTrue(s2.getMaxSize() == 2);
	    pushInt = 1;
	    s2.push(pushInt);
	    pushInt = 2;
	    s2.push(pushInt);
	    String retStr = s2.toString();
	    int numLines = utils.MyUtils.numberLines(retStr);
	    assertEquals(2,numLines);
	    s2.clear();
	    retStr = s2.toString();
	    numLines = utils.MyUtils.numberLines(retStr);
	    assertEquals(0,numLines);
	    s2.push(pushInt);
	    pushInt = 2;
	    s2.push(pushInt);
	    retStr = s2.toString();
	    numLines = utils.MyUtils.numberLines(retStr);
	    assertEquals(2,numLines);
	   
	}

	public void queueTest()
	{
		String pushString="";
		int pushInt = 0;
		QueueList <String> q1 = new QueueListImpl<String>(3);
		QueueList<Integer> q2 = new QueueListImpl<Integer>(2);
		QueueList <String> q3 = new QueueListImpl<String>();
		QueueList <String> q4 = new QueueListImpl<String>(-3);
		QueueList<String> s5 = new QueueListImpl<String>(QueueList.LARGEST);
		QueueList<String> s6 = new QueueListImpl<String>(OVER_LARGEST);
		assertTrue(s5.getMaxSize()==QueueList.LARGEST);
		assertTrue(s6.getMaxSize() == QueueList.DEFAULT_MAX_SIZE);
		assertTrue(q3.getMaxSize() == QueueList.DEFAULT_MAX_SIZE);
		assertTrue(q4.getMaxSize() == QueueList.DEFAULT_MAX_SIZE);
		assertTrue(q1.getMaxSize()==3);
		assertTrue(q2.getMaxSize()==2);
		assertTrue(q1.isEmpty());
		assertTrue(q2.isEmpty());
		pushString = "first";
		q1.add(pushString);
		assertTrue(q1.getSize() == 1);
		assertFalse(q1.isEmpty());
		assertFalse(q1.isFull());
		assertTrue(q1.getFront().equals(pushString));
		assertTrue(q1.getRear().equals(pushString));
		pushString = "second";
		q1.add(pushString);
		assertTrue(q1.getSize() == 2);
		assertFalse(q1.isEmpty());
		assertFalse(q1.isFull());
		assertTrue(q1.getFront().equals("first"));
		assertTrue(q1.getRear().equals(pushString));
		pushString = "third";
		q1.add(pushString);
		assertTrue(q1.getSize() == 3);
		assertFalse(q1.isEmpty());
		assertTrue(q1.isFull());
		assertTrue(q1.getFront().equals("first"));
		assertTrue(q1.getRear().equals(pushString));
		System.out.println("Now testing toString() for QueueListImpl");
		String out = q1.toString();
		System.out.println("****\n" + "toString()\n" + out + "****");
		int numLines = utils.MyUtils.numberLines(out);
		assertTrue(numLines == 3);
		StringTokenizer tokenizer = new StringTokenizer(out);
		String token = tokenizer.nextToken();
		assertTrue(token.equals("first"));
		token = tokenizer.nextToken();
		assertTrue(token.equals("second"));
		token = tokenizer.nextToken();
		assertTrue(token.equals("third"));

		pushString = "fourth";
		try {
			q1.add(pushString);

			System.out.println("FAILURE, add should throw a RuntimeException on a FULL QUEUE");
		}catch (RuntimeException e) 
		{
			System.out.println("SUCCESS, add throws a RuntimeException on a FULL QUEUE\n" + e);
		}
		assertTrue(q1.remove().equals("first"));
		out = q1.toString();
		numLines = utils.MyUtils.numberLines(out);
		assertTrue(numLines == 2);

		assertTrue(q1.getSize()==2);
		assertFalse(q1.isEmpty());
		assertFalse(q1.isFull());
		assertTrue(q1.remove().equals("second"));
		assertTrue(q1.getSize()==1);
		assertFalse(q1.isEmpty());
		assertFalse(q1.isFull());
		assertTrue(q1.remove().equals("third"));
		assertTrue(q1.getSize()==0);
		assertTrue(q1.isEmpty());
		assertFalse(q1.isFull());
		try {
			q1.getFront();

			System.out.println("FAILURE, getFront() should throw a RuntimeException on an EMPTY QUEUE");
			assertFalse(true);
		}catch (RuntimeException e) 
		{
			System.out.println("SUCCESS, getFront() throws a RuntimeException on an EMPTY QUEUE\n" + e);
			
		}
		try {
			q1.getRear();
			System.out.println("FAILURE, getRear() should throw a RuntimeException on an EMPTY QUEUE");
			assertFalse(true);
		}catch (RuntimeException e) 
		{
			System.out.println("SUCCESS, getRear() throws a RuntimeException on and EMPTY QUEUE\n" + e);
		}
		try {
			q1.remove();
			System.out.println("FAILURE, remove() should throw a RuntimeException on an EMPTY QUEUE");
			assertFalse(true);
		}catch (RuntimeException e) 
		{
			System.out.println("SUCCESS, remove() throws a RuntimeException on an EMPTY QUEUE\n" + e);
		}
		pushString = "first";
		q1.add(pushString);
		assertTrue(q1.getSize() == 1);
		assertFalse(q1.isEmpty());
		assertFalse(q1.isFull());
		assertTrue(q1.getFront().equals(pushString));
		assertTrue(q1.getRear().equals(pushString));
		String remResult = q1.remove();
		assertTrue(remResult.equals(pushString));
		assertTrue(q1.getSize() == 0);
		assertTrue(q1.isEmpty());
		assertFalse(q1.isFull());
		try {
			q1.remove();
			System.out.println("FAILURE, remove() should throw a RuntimeException on an EMPTY QUEUE");
			assertFalse(true);
		}catch (RuntimeException e) 
		{
			System.out.println("SUCCESS, remove() throws a RuntimeException on an EMPTY QUEUE\n" + e);
		}
		System.out.println("****  Now testing QueueList of Integer ****");
		pushInt = 1;
		q2.add(pushInt);
		assertTrue(q2.getSize() == 1);
		assertFalse(q2.isEmpty());
		assertFalse(q2.isFull());
		assertTrue(q2.getFront()==(pushInt));
		assertTrue(q2.getRear()==(pushInt));
		pushInt = 2;
		q2.add(pushInt);
		assertTrue(q2.getSize() == 2);
		assertFalse(q2.isEmpty());
		assertTrue(q2.isFull());
		assertTrue(q2.getFront()==(1));
		assertTrue(q2.getRear()==pushInt);
		pushInt = 3;
		try {
			q2.add(pushInt);
			System.out.println("FAILURE, add() should throw a RuntimeException on a FULL QUEUE");
			assertFalse(true);
		}catch (RuntimeException e) 
		{
			System.out.println("SUCCESS, add() throws a RuntimeException on a FULL QUEUE\n" + e);
		}
		assertTrue(q2.isFull());
		assertTrue(q2.getSize() == 2);
		int remInt =0;
		remInt = q2.remove();
		assertTrue(remInt == 1);
		assertTrue(q2.getSize() == 1);
		assertTrue(q2.getFront() == 2);
		assertTrue(q2.getRear() == 2);
		remInt = q2.remove();
		assertTrue(remInt == 2);
		assertTrue(q2.isEmpty());
		assertFalse(q2.isFull());
		assertTrue(q2.getSize() == 0);
		try {
			q2.remove();
			System.out.println("FAILURE, remove() should throw a RuntimeException on an EMPTY QUEUE");
			assertFalse(true);
		}catch (RuntimeException e) 
		{
			System.out.println("SUCCESS, remove() throws a RuntimeException on an EMPTY QUEUE\n" + e);
		}
		try {
			q2.getRear();
			System.out.println("FAILURE, getRear() should throw a RuntimeException on an EMPTY QUEUE");
			assertFalse(true);
		}catch (RuntimeException e) 
		{
			System.out.println("SUCCESS, getRear() throws a RuntimeException on and EMPTY QUEUE\n" + e);
		}
		try {
			q2.remove();
			System.out.println("FAILURE, remove() should throw a RuntimeException on an EMPTY QUEUE");
			assertFalse(true);
		}catch (RuntimeException e) 
		{
			System.out.println("SUCCESS, remove() throws a RuntimeException on an EMPTY QUEUE\n" + e);
		}
		pushInt = 1;
		q2.add(pushInt);
		assertTrue(q2.getSize() == 1);
		assertFalse(q2.isEmpty());
		assertFalse(q2.isFull());
		assertTrue(q2.getFront()==(pushInt));
		assertTrue(q2.getRear()==(pushInt));
		remInt = q2.remove();
		assertTrue(remInt == pushInt);
		assertTrue(q2.isEmpty());
		assertFalse(q2.isFull());
		assertTrue(q2.getSize() == 0);
		try {
			q2.remove();
			System.out.println("FAILURE, remove() should throw a RuntimeException on an EMPTY QUEUE");
			assertFalse(true);
		}catch (RuntimeException e) 
		{
			System.out.println("SUCCESS, remove() throws a RuntimeException on an EMPTY QUEUE\n" + e);
		}
		try {
			q2.getRear();
			System.out.println("FAILURE, getRear() should throw a RuntimeException on an EMPTY QUEUE");
			assertFalse(true);
		}catch (RuntimeException e) 
		{
			System.out.println("SUCCESS, getRear() throws a RuntimeException on and EMPTY QUEUE\n" + e);
		}
		try {
			q2.remove();
			System.out.println("FAILURE, remove() should throw a RuntimeException on an EMPTY QUEUE");
			assertFalse(true);
		}catch (RuntimeException e) 
		{
			System.out.println("SUCCESS, remove() throws a RuntimeException on an EMPTY QUEUE\n" + e);
		}

		//testing clear()
		pushInt = 1;
		q2.add(pushInt);
		assertTrue(q2.getSize()==1);
		q2.clear();
		assertTrue(q2.getSize() ==0);
		q2.add(pushInt);
		assertTrue(q2.getSize()==1);
		assertTrue(q2.getFront() == pushInt);
		assertTrue(q2.getRear() == pushInt);
		pushInt = 2;
		q2.add(pushInt);
		assertTrue(q2.getSize()==2);
		assertTrue(q2.getFront() == 1);
		assertTrue(q2.getRear() == pushInt);
		assertTrue(q2.isFull());
		q2.clear();
		String retStr = q2.toString();
		numLines = utils.MyUtils.numberLines(retStr);
		assertEquals(0, numLines);
		assertTrue(q2.isEmpty());
		System.out.println("SUCCESS QueueTesting PASSES");
	}
	
}
