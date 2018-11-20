<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleServicemainProxyid" scope="session" class="com.mscd5510.web.service.ServicemainProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleServicemainProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleServicemainProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleServicemainProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        com.mscd5510.web.service.Servicemain getServicemain10mtemp = sampleServicemainProxyid.getServicemain();
if(getServicemain10mtemp == null){
%>
<%=getServicemain10mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
</TABLE>
<%
}
break;
case 15:
        gotMethod = true;
        java.lang.String getValues15mtemp = sampleServicemainProxyid.getValues();
if(getValues15mtemp == null){
%>
<%=getValues15mtemp %>
<%
}else{
        String tempResultreturnp16 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getValues15mtemp));
        %>
        <%= tempResultreturnp16 %>
        <%
}
break;
case 18:
        gotMethod = true;
        String id_1id=  request.getParameter("id21");
            java.lang.String id_1idTemp = null;
        if(!id_1id.equals("")){
         id_1idTemp  = id_1id;
        }
        String field_2id=  request.getParameter("field23");
            java.lang.String field_2idTemp = null;
        if(!field_2id.equals("")){
         field_2idTemp  = field_2id;
        }
        String new_value_3id=  request.getParameter("new_value25");
            java.lang.String new_value_3idTemp = null;
        if(!new_value_3id.equals("")){
         new_value_3idTemp  = new_value_3id;
        }
        boolean updateValue18mtemp = sampleServicemainProxyid.updateValue(id_1idTemp,field_2idTemp,new_value_3idTemp);
        String tempResultreturnp19 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(updateValue18mtemp));
        %>
        <%= tempResultreturnp19 %>
        <%
break;
case 27:
        gotMethod = true;
        String id_4id=  request.getParameter("id30");
            java.lang.String id_4idTemp = null;
        if(!id_4id.equals("")){
         id_4idTemp  = id_4id;
        }
        boolean removeValue27mtemp = sampleServicemainProxyid.removeValue(id_4idTemp);
        String tempResultreturnp28 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(removeValue27mtemp));
        %>
        <%= tempResultreturnp28 %>
        <%
break;
case 32:
        gotMethod = true;
        String id_5id=  request.getParameter("id35");
            java.lang.String id_5idTemp = null;
        if(!id_5id.equals("")){
         id_5idTemp  = id_5id;
        }
        String name_6id=  request.getParameter("name37");
            java.lang.String name_6idTemp = null;
        if(!name_6id.equals("")){
         name_6idTemp  = name_6id;
        }
        String cardno_7id=  request.getParameter("cardno39");
            java.lang.String cardno_7idTemp = null;
        if(!cardno_7id.equals("")){
         cardno_7idTemp  = cardno_7id;
        }
        String unitPrice_8id=  request.getParameter("unitPrice41");
            java.lang.String unitPrice_8idTemp = null;
        if(!unitPrice_8id.equals("")){
         unitPrice_8idTemp  = unitPrice_8id;
        }
        String quantity_9id=  request.getParameter("quantity43");
            java.lang.String quantity_9idTemp = null;
        if(!quantity_9id.equals("")){
         quantity_9idTemp  = quantity_9id;
        }
        String totalPrice_10id=  request.getParameter("totalPrice45");
            java.lang.String totalPrice_10idTemp = null;
        if(!totalPrice_10id.equals("")){
         totalPrice_10idTemp  = totalPrice_10id;
        }
        String expDate_11id=  request.getParameter("expDate47");
            java.lang.String expDate_11idTemp = null;
        if(!expDate_11id.equals("")){
         expDate_11idTemp  = expDate_11id;
        }
        boolean insertValue32mtemp = sampleServicemainProxyid.insertValue(id_5idTemp,name_6idTemp,cardno_7idTemp,unitPrice_8idTemp,quantity_9idTemp,totalPrice_10idTemp,expDate_11idTemp);
        String tempResultreturnp33 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(insertValue32mtemp));
        %>
        <%= tempResultreturnp33 %>
        <%
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>