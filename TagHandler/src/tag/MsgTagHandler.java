package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import model.DataBean;

public class MsgTagHandler extends SimpleTagSupport{

	private String bgcolor;
	private String border;
	
	public void doTag() throws IOException, JspException {
		JspWriter out = getJspContext().getOut();
		JspFragment body = getJspBody();
		
		// 인보크 때문에 이프문이 없으면 안된다.
		if(body!=null) { //만약에 태그바디가 있다면
			out.println("<h1>");
			body.invoke(null);
			out.println("</h1>");
		}
		
		DataBean db=new DataBean();
			
		// out 내장객체가 일을 많이하는 편이다. 스트링버퍼를 이용해보자
		
/*		out.println("<table border=");
		out.println(border);
		out.println(" bgcolor=");
		out.println(bgcolor);
		out.println(">");*/
		
		StringBuffer sb=new StringBuffer();
		sb.append("<table border=").append(border).append(" bgcolor=").append(bgcolor).append(">메세지 실습</font></p>");
		
		out.println(sb.toString());
		
		for(String v : db.getDataList()) {
			out.println("<tr><td>"+v+"</tr></td>");
		}
		out.println("</table>");
	}

	public String getBgcolor() {
		return bgcolor;
	}

	public void setBgcolor(String bgcolor) {
		this.bgcolor = bgcolor;
	}

	public String getBorder() {
		return border;
	}

	public void setBorder(String border) {
		this.border = border;
	}
	
	
	
	
}
