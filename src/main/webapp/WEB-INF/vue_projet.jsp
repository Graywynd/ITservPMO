<%-- 
    Document   : vue_projet
    Created on : 28 juil. 2016, 15:45:58
    Author     : saif
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vue Projet</title>
        <script src="assets/js/jquery-3.1.0.js"></script>   
        <link href="assets/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/css/datepicker3.css" rel="stylesheet">
        <link href="assets/css/styles.css" rel="stylesheet">
        <link href="assets/css/font-awesome.css" rel="stylesheet">
        
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
                
                <br>
    <div class="row">
			<div class="col-lg-12">
				<h2>Nom Compte - Label Projet</h2>
			</div>
			
			
			
			<div class="col-md-6 col-lg-12">
				<div class="panel panel-default">
					<div class="panel-body tabs">
					
						<ul class="nav nav-pills">
							<li class="active"><a href="#pilltab1" data-toggle="tab">Infos</a></li>
							<li><a href="#pilltab2" data-toggle="tab">Activités</a></li>
							<li><a href="#pilltab3" data-toggle="tab">Paramètres</a></li>
						</ul>
		
						<div class="tab-content">
							<div class="tab-pane fade in active" id="pilltab1">
                                                            <h3><strong>Nom Projet</strong></h3>
                                                            <h6><strong>Responsable/Consultant</strong></h6>
                                                            <br><br>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec eget rutrum purus. Donec hendrerit ante ac metus sagittis elementum. Mauris feugiat nisl sit amet neque luctus, a tincidunt odio auctor. </p>
                                                                <br>
                                                                <br>
                                                                <table class="table table-condensed">
                                                                    <thead>
                                                                       <tr>
                                                                          <th colspan="3"><h3>Infos Projet</h3></th>
                                                                       </tr>
                                                                    </thead>
                                                                    <tbody>
                                                                        <tr>
                                                                             <td><b>Info</b></td>
                                                                              <td>
                                                                                    <a href="#" class="ng-binding">
                                                                                             www.example.com
                                                                                                                 </a></td>
                                                                        </tr>
                                                                           <tr>
                                                                              <td><b>Info</b></td>
                                                                              <td>
                                                                        <a href="" class="ng-binding">
                                                                                         www.example.com
                                                                                </a></td>
                                                                           </tr>
                                                                            <tr>
                                                                              <td><b>Info</b></td>
                                                                                <td class="ng-binding">+(216)97564521</td>
                                                                             </tr>
                                                                             <tr>
                                                                               <td><b>Info</b></td>
                                                                                 <td>
                                                                                     <a href="" class="ng-binding">
                                                                                                     www.example.com
                                                                                                         </a></td>
                                                                             </tr>
                                                                    </tbody>
                                                                </table>
                                                                
                                                                
							</div>
							
                                                    
                                                    <div class="tab-pane fade" id="pilltab2">
                                                        <h3><strong>Activités</strong> </h3>
                                                        <br><br>
                                                        
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec eget rutrum purus. Donec hendrerit ante ac metus sagittis elementum. Mauris feugiat nisl sit amet neque luctus, a tincidunt odio auctor. </p>
                                                                <br><br>
                                                                
                                                           <div class="panel panel-default">                 
                                                                <div class="btn-group btn-group-justified m-b-10">
                                    <a class="btn btn-primary" role="button">Actions</a>
                                    <a class="btn btn-primary" role="button">Demandes</a>
                                    <a class="btn btn-primary" role="button">Risuqes</a>
                                    <a class="btn btn-primary" role="button">Point en Suspens</a>
                                </div>
                                                           </div>
                                                                <br>
                                                                <br>
                                                                
                                                                <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><strong>Table Sous-projets</strong></h3>
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                        <table class="table table-hover">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>Col 1</th>
                                                    <th>Col 2</th>
                                                    <th>Col 3</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>1</td>
                                                    <td>Case</td>
                                                    <td>Case</td>
                                                    <td>Case</td>
                                                </tr>
                                                <tr>
                                                    <td>2</td>
                                                    <td>Case</td>
                                                    <td>Case</td>
                                                    <td>Case</td>
                                                </tr>
                                                <tr>
                                                    <td>3</td>
                                                    <td colspan="2">Case</td>
                                                    <td>Case</td>
                                                </tr>
                                                <tr>
                                                    <td>4</td>
                                                    <td>Case</td>
                                                    <td>Case</td>
                                                    <td>Case</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                                                                
                                                                <br><br>
                                                               
                                                                
                                                                
							</div>
							
                                                    
                                                    
                                                    <div class="tab-pane fade" id="pilltab3">
                                                        <h3><strong>Paramètres</strong> </h3>
                                                                <br><br>
                                                                
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec eget rutrum purus. Donec hendrerit ante ac metus sagittis elementum. Mauris feugiat nisl sit amet neque luctus, a tincidunt odio auctor. </p>
                                                                
                                                                <br><br>
                                                                
                                                                <div class="user-profile-content">
                                        <form role="form">
                                            <div class="form-group">
                                                <label for="FullName">Label Projet</label>
                                                <input type="text" value="Projet#1" id="FullName" class="form-control">
                                            </div>
                                            <div class="form-group">
                                                <label for="Email">Statut</label>
                                                <input type="email" value="En Cours" id="Email" class="form-control">
                                            </div>
                                            <div class="form-group">
                                                <label for="Username">Date Cloture</label>
                                                <input type="text" value="12/08/16" id="Username" class="form-control">
                                            </div>
                                           
                                            
                                            <div class="form-group">
                                                <label for="AboutMe">Description</label>
                                                <textarea style="height: 125px;" id="AboutMe" class="form-control">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.</textarea>
                                            </div>
                                            <button class="btn btn-primary" type="submit">Valider</button>
                                        </form>
                                    </div>
							</div>
						</div>
					</div>
				</div><!--/.panel-->
			</div><!-- /.col-->
			
		</div><!-- /.row -->
        
    </div> <!-- main -->
        
      <!--   <script src="https://cdn.jsdelivr.net/holder/2.9.0/holder.min.js"></script> -->
         <script src="assets/js/jquery-1.11.1.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/chart.min.js"></script>
	<script src="assets/js/chart-data.js"></script>
	<script src="assets/js/easypiechart.js"></script>
	<script src="assets/js/easypiechart-data.js"></script>
	<script src="assets/js/bootstrap-datepicker.js"></script>
    </body>
</html>
