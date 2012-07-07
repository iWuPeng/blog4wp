package com.wupeng.blog.util.lang;

public class StringTokenizer implements java.util.Enumeration
{
	/** token个数 */
	private int count = 0;
	/** 存储token信息 */
	private java.util.Vector tokens = new java.util.Vector();
	/** 分隔的字符串 */
	private String strToken;
	/** 分隔符 */
	private String seperator = " ";

	/**
	 * 构造函数
	 * @param strToken 分隔的字符串
	 * @param seperator 分隔符
	 * @throws NullPointerException
	 */
	public StringTokenizer(String strToken,String seperator) throws NullPointerException
	{
		if (strToken==null)
			throw new NullPointerException();
		this.strToken = strToken;
		this.seperator = seperator;
		init();
	}

	/**
	 * 初始化函数
	 */
	private void init()
	{
		int index = 0;
		String substr = strToken.substring(index);
		while((index=substr.indexOf(seperator))>=0)
		{
			System.out.println("substr.substring(0,index):"+substr.substring(0,index));
            tokens.add(substr.substring(0,index));

			substr = substr.substring(index+seperator.length());
		}
        if(strToken.lastIndexOf(seperator)==-1){
            tokens.add(strToken.substring(0));
        }else{
            tokens.add(strToken.substring(strToken.lastIndexOf(seperator) +
                                          seperator.length()));
        }
	}

	/**
	 * 判断是否还有token
	 * @return 是否到末尾
	 */
	public boolean hasMoreTokens()
	{
		return hasMoreElements();
	}


	/**
	 * 实现Enumeration的hasMoreElements()
	 * @return 是否到末尾
	 */
	public boolean hasMoreElements()
	{
		if (count++<tokens.size())
			return true;
		return false;
	}

	/**
	 * 取出下一个token
	 * @return 下一个token
	 */
	public String nextToken()
	{
		return (String)nextElement();
	}

	/**
	 * 实现Enumeration的nextElement()
	 * @return 下一个对象
	 */
	public Object nextElement()
	{
		return tokens.elementAt(count-1);
	}

	/**
	 * 取得token的数目
	 * @return token的数目
	 */
	public int countTokens()
	{
		return tokens.size();
	}

    public static void main(String[] args) {
        StringTokenizer st=new StringTokenizer("type=1","||");
        while (st.hasMoreElements()) {
            String strTemp = (String) st.nextToken();
            System.out.println("strTemp:" + strTemp);

//					System.out.println("st:"+strTemp);
        }

    }
}
