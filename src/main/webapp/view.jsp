<%@page import="com.axelor.pojo.MobileNum"%>
<%@page import="javax.persistence.Query"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.axelor.pojo.Name"%>
<%@page import="java.util.List"%>
<%@page import="com.axelor.guice.GuiceService"%>
<%@page import="com.google.inject.persist.PersistService"%>
<%@page import="com.google.inject.persist.jpa.JpaPersistModule"%>
<%@page import="com.google.inject.Guice"%>
<%@page import="com.google.inject.Injector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
#t1, th {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>
<body>
<form action="post">
  <center>
  <h1>Contacts</h1>
    <table id = "t1">
      <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Number</th>
      </tr>
      
      <%
      
        Injector inject = Guice.createInjector(new JpaPersistModule("testDB"));
        PersistService ps = inject.getInstance(PersistService.class);
		ps.start();
		
	    GuiceService gs = inject.getInstance(GuiceService.class);
	  
	    List<Name> list1 = new ArrayList<Name>();
	   
	    Query query = gs.em.createQuery("select n from Name n");
	   
	    list1 = query.getResultList();
	   
	    for(Name name:list1) {
		   
	 %>
	   
	   <tr>
	    <td  id = "t1"><%= name.getId() %></td>
	    <td  id = "t1"><%= name.getName() %></td>
	    <td id = "t1">
	    
	     <table>
	    
	    <%
	       List<MobileNum> list2 = new ArrayList<MobileNum>();
	       list2 = name.getNumber();
	    
	       for(MobileNum mob:list2) {
	    %>
	       
	       
	         <tr><td><%=mob.getNumber() %></td></tr>
	         
	   <%   	   
	       }
	   %>
	    </table>
	   </td>
	  </tr>
	<%     
	   }
	 %>
    
    </table>
    
    <br>
    
    <input type = "submit" value = "Delete" formaction = "http://localhost:8081/Guice-Hibernate-RestEasy/delete.jsp">
    <input type = "submit" value = "Add" formaction = "http://localhost:8081/Guice-Hibernate-RestEasy/add.html">
    
    
  
  </center>

</form>
</body>
</html>