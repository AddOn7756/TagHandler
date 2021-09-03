package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MsgTestHandler extends SimpleTagSupport {

	private String size;
	private String color;
	
	public void doTag() throws IOException, JspException{
		
		StringBuffer sb=new StringBuffer(); // 스트링버퍼 out의 반복을 줄여줌
		JspFragment body = getJspBody(); // 두바디 값 받아오기
		JspWriter out = getJspContext().getOut();
		
		if(body!=null) { //만약에 태그바디가 있다면
			sb.append("<p><font color= ").append(color).append(" size=").append(size).append(">");
			
			/*out.println("<p><font=");
			out.println(color);
			out.println(" size=");
			out.println("size >");
			out.println("<p><font=");*/
			out.println(sb.toString());
			body.invoke(null);
			out.println("</font></p>");
		}
	}
	
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
	
}
