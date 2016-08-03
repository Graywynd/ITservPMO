<%-- 
    Document   : list_action
    Created on : 22 juil. 2016, 12:45:39
    Author     : saif
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Vector"%>
<%@page import="com.hibernate.Action"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="assets/js/jquery-3.1.0.js"></script>   
        <link href="assets/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/css/datepicker3.css" rel="stylesheet">
        <link href="assets/css/styles.css" rel="stylesheet">

<!--Icons-->
<script src="assets/js/lumino.glyphs.js"></script>
    </head>
    <body>
         <div id="navigation"></div>
          <script> 
    $(function(){
      $("#navigation").load("nav.html"); 
    });
    </script> 
    
    <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
				<li class="active">Icons</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Comptes</h1>
			</div>
		</div><!--/.row-->
				
		
		<div class="row">
			<div class="col-lg-12 ">
				<div class="panel panel-default">
					<div class="panel-heading">Tableau d'actions</div>
					<div class="panel-body ">
                                           <div class="table-responsive">
                                            <table  data-toggle="table" data-url="data1.json"  data-show-refresh="true" data-show-toggle="true" data-show-columns="true" data-search="true" data-select-item-name="toolbar1" data-pagination="true" data-sort-name="name" data-sort-order="desc">
						    <thead>
						    <tr>
						        <th data-field="number" data-sortable="true" >N°</th>
						        <th data-field="titre" >Action</th>
                                                        <th data-field="chantier" >Chantier</th>
						        <th data-field="statut" data-sortable="true">Statut</th>
                                                        <th data-field="responsable" >Responsable</th>
						        <th data-field="priorite" data-sortable="true">Priorité</th>
                                                        <th data-field="dteplan" data-sortable="true">Cloture Planifié</th>
                                                        <th data-field="dtereal" data-sortable="true">Cloture Réelle</th>
                                                        
						    </tr>
						    </thead>
                                                    <tbody>
                                                        <%
            ArrayList clients=(ArrayList)session.getAttribute("actions");
            for(int i=0;i<clients.size();i++){
            Action a=(Action)clients.get(i);
            %>
                                                        
                                                        <tr>
                                                            <td> <%= a.getActionNum()%> </td>
                                                            <td> <%= a.getActionTitre()%> </td>
                                                            <td> <%= a.getChantier().getChantierLabel() %> </td>
                                                            <td> <%= a.getActionStatut()%> </td>
                                                            <td> <%= a.getUtilisateur().getUtilisateurNom()%> <%= a.getUtilisateur().getUtilisateurPrenom()%> </td>
                                                            <td> <%= a.getActionPriorite()%> </td>
                                                            <td> <%= a.getActionCloturePlanDte().toString().substring(0,10)%> </td>
                                                            <td> <%= a.getActionClotureRealDte().toString().substring(0,10)%> </td>
                                                        </tr>
                                                         <%
                                 }

                                 %>
                                                        
                                                    </tbody>
                                                    
						</table>
                                           </div>
					</div>
				</div>
			</div>
		</div><!--/.row-->	
		
               
		
		
	</div><!--/.main-->	
        
                
                
                
        <script src="assets/js/jquery-1.11.1.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/chart.min.js"></script>
	<script src="assets/js/chart-data.js"></script>
	<script src="assets/js/easypiechart.js"></script>
	<script src="assets/js/easypiechart-data.js"></script>
	<script src="assets/js/bootstrap-datepicker.js"></script>
	<script src="assets/js/bootstrap-table.js"></script>
	<script>
		!function ($) {
			$(document).on("click","ul.nav li.parent > a > span.icon", function(){		  
				$(this).find('em:first').toggleClass("glyphicon-minus");	  
			}); 
			$(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
		}(window.jQuery);

		$(window).on('resize', function () {
		  if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
		})
		$(window).on('resize', function () {
		  if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
		})
	</script>	
    </body>
</html>
