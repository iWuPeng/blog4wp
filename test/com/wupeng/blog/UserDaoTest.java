package com.wupeng.blog;

import junit.framework.TestCase;

import org.junit.Test;

public class UserDaoTest extends TestCase
{
	public void testAdd()
	{
		int x = 10;
		int y = 20;
		System.out.println("x+y="+(x+y));
		assertEquals(30, x+y+1);
	}
	
	public static void main(String[] args) 
	{
		System.out.println("Hello,World!");
	}
}
