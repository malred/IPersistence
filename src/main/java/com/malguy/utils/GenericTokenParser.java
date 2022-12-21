package com.malguy.utils;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class GenericTokenParser {
    private final String openToken;//开始标记
    private final String closeToken;//结束标记
    private final TokenHandler handler;//标记处理器
    public GenericTokenParser(String openToken, String closeToken, TokenHandler handler) {
        this.openToken = openToken;
        this.closeToken = closeToken;
        this.handler = handler;
    }

    /**
     * 解析${}和#{}
     * @param text 传入的文本,包含${}或#{}
     * @return
     */
    public String parse(String text) {
        //验证参数问题,如果为null,就返回空串
        if(text==null||text.isEmpty()){
            return "";
        }
        //验证是否包含开始标签,不包含默认不是占位符,原样返回
        int start=text.indexOf(openToken,0);
        if(start==-1){
            return text;
        }
        //text转成字符数组src,定义默认偏移量offset=0,存储最终需要返回的字符串变量builder
        //text变量中占位符对应变量名expression,判断start是否>-1(text中是否包含openToken),存在就执行下面代码
        char[] src=text.toCharArray();
        int offset = 0;
        final StringBuilder builder = new StringBuilder();
        StringBuilder expression = null;
        while(start>-1){
            //判断如果开始标记前有转义字符,就不作为openToken进行处理,否则继续
            if(start>0&&src[start-1]=='\\'){
                builder.append(src,offset,start-offset-1).append(openToken);
                offset=start+openToken.length();
            }else{
                //重置expression变量,避免空指针或老数据干扰
                if(expression==null){
                    expression=new StringBuilder();
                }else{
                    expression.setLength(0);
                }
                builder.append(src,offset,start-offset);
//                System.out.println(builder.toString());//yes
                offset=start+openToken.length();
                int end = text.indexOf(closeToken,offset);
                while(end>-1) {//存在结束标记时
                    if(end>offset&&src[end-1]=='\\'){//如果结束标记前有转义字符
                        expression.append(src,offset,end-offset);
                        offset=end+closeToken.length();
                        break;
                    }else{
                        //不存在转义字符,需要作为参数处理
                        expression.append(src,offset,end-offset);
                        offset=end+closeToken.length();
                        break;
                    }
                }
                if(end==-1){
                    builder.append(src,start,src.length-start);
                    offset=src.length;
                }else{
                    //首先根据参数的key(即expression)进行参数处理,返回?作为占位符
                    builder.append(handler.handlerToken(expression.toString()));
                    offset=end+closeToken.length();
                }
            }
            start=text.indexOf(openToken,offset);
        }
        if(offset<src.length){
            builder.append(src,offset,src.length-offset);
        }
        return builder.toString();
    }
}
