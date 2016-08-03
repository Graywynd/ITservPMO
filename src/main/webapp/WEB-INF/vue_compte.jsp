<%-- 
    Document   : vue_projet
    Created on : 28 juil. 2016, 12:39:02
    Author     : saif
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vue Compte</title>
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
      <div class="panel panel-default">
        <div class="panel-body">
          <div class="row">
            <div class="col-md-12 lead">Profil Compte<hr></div>
          </div>
          <div class="row">
			<div class="col-md-4 text-center">
              <img class="img-circle img-responsive avatar avatar-original" style="-webkit-user-select:none; 
              display:block; margin:auto;" src="assets/img/logo-it-serv.jpg">
            </div>
            <div class="col-md-8">
              <div class="row">
                <div class="col-md-12">
                  <h1 class="only-bottom-margin">ITSERV</h1>
                </div>
              </div>
              <div class="row">
                <div class="col-md-6">
                  <span class="text-muted">Info:</span> xxxxxxxxxx<br>
                  <span class="text-muted">Info:</span> xxxxxxxxxx<br>
                  <span class="text-muted">Info:</span> xxxxxxxxxx<br><br>
                  <small class="text-muted">xxxxxxxxxxxxxxxxx</small>
                </div>
                <div class="col-md-6">
                    <div>
                    <a class="btn btn-social-icon btn-facebook" ><span class="fa fa-facebook"></span></a>
                    </div>
                    <div>
                    <a class="btn btn-social-icon btn-linkedin" ><span class="fa fa-linkedin"></span></a>
                    </div>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-12">
              <hr><button class="btn btn-default pull-right"><i class="glyphicon glyphicon-pencil"></i> Edit</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

                
                <div class="row">
			<div class="col-xs-12 col-md-4 col-lg-4">
				<div class="panel panel-blue panel-widget ">
					<div class="row no-padding">
						<div class="col-sm-3 col-lg-5 widget-left">
							<svg class="glyph stroked table"><use xlink:href="#stroked-table"/></svg>
						</div>
						<div class="col-sm-9 col-lg-7 widget-right">
							<div class="large">23</div>
							<div class="text-muted">Projets en cours</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-md-4 col-lg-4">
				<div class="panel panel-orange panel-widget">
					<div class="row no-padding">
						<div class="col-sm-3 col-lg-5 widget-left">
							<i class="fa fa-exclamation-circle fa-4x" aria-hidden="true"></i>
						</div>
						<div class="col-sm-9 col-lg-7 widget-right">
							<div class="large">127</div>
							<div class="text-muted">Actions en cours</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-md-4 col-lg-4">
				<div class="panel panel-teal panel-widget">
					<div class="row no-padding">
						<div class="col-sm-3 col-lg-5 widget-left">
							<svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg>
						</div>
						<div class="col-sm-9 col-lg-7 widget-right">
							<div class="large">9</div>
							<div class="text-muted">Utilisateurs</div>
						</div>
					</div>
				</div>
			</div>
		
		</div><!--/.row-->
                
                <div class="row">
                    <div class="container col-lg-12">
                   <div class="panel panel-blue">
					<div class="panel-heading dark-overlay"><svg class="glyph stroked clipboard-with-paper"><use xlink:href="#stroked-clipboard-with-paper"></use></svg>Projects en cours</div>
					<div class="panel-body" style="min-height: 400px; max-height: 400px;overflow-y: scroll;">
						<ul class="todo-list">
						<li class="todo-list-item" >
                                                    <div class="checkbox">
									<svg class="glyph stroked calendar"><use xlink:href="#stroked-calendar"/></svg>
									<label for="checkbox">Project</label>
								</div>
								<div class="pull-right action-buttons">
									<a href="vueprojet.htm"><svg class="glyph stroked pencil"><use xlink:href="#stroked-pencil"></use></svg></a>
									<a href="#" class="flag"><svg class="glyph stroked flag"><use xlink:href="#stroked-flag"></use></svg></a>
									<a href="#" class="trash"><svg class="glyph stroked trash"><use xlink:href="#stroked-trash"></use></svg></a>
								</div>
                                                </li> 
							<li class="todo-list-item" >
								<div class="checkbox">
									<svg class="glyph stroked calendar"><use xlink:href="#stroked-calendar"/></svg>
									<label for="checkbox">Project</label>
								</div>
								<div class="pull-right action-buttons">
									<a href="vueprojet.htm"><svg class="glyph stroked pencil"><use xlink:href="#stroked-pencil"></use></svg></a>
									<a href="#" class="flag"><svg class="glyph stroked flag"><use xlink:href="#stroked-flag"></use></svg></a>
									<a href="#" class="trash"><svg class="glyph stroked trash"><use xlink:href="#stroked-trash"></use></svg></a>
								</div>
							</li>
							<li class="todo-list-item">
								<div class="checkbox">
									<svg class="glyph stroked calendar"><use xlink:href="#stroked-calendar"/></svg>
									<label for="checkbox">Project</label>
								</div>
								<div class="pull-right action-buttons">
									<a href="vueprojet.htm"><svg class="glyph stroked pencil"><use xlink:href="#stroked-pencil"></use></svg></a>
									<a href="#" class="flag"><svg class="glyph stroked flag"><use xlink:href="#stroked-flag"></use></svg></a>
									<a href="#" class="trash"><svg class="glyph stroked trash"><use xlink:href="#stroked-trash"></use></svg></a>
								</div>
							</li>
							<li class="todo-list-item">
								<div class="checkbox">
									<svg class="glyph stroked calendar"><use xlink:href="#stroked-calendar"/></svg>
									<label for="checkbox">Project</label>
								</div>
								<div class="pull-right action-buttons">
									<a href="#"><svg class="glyph stroked pencil"><use xlink:href="#stroked-pencil"></use></svg></a>
									<a href="#" class="flag"><svg class="glyph stroked flag"><use xlink:href="#stroked-flag"></use></svg></a>
									<a href="#" class="trash"><svg class="glyph stroked trash"><use xlink:href="#stroked-trash"></use></svg></a>
								</div>
							</li>
							<li class="todo-list-item">
								<div class="checkbox">
									<svg class="glyph stroked calendar"><use xlink:href="#stroked-calendar"/></svg>
									<label for="checkbox">Project</label>
								</div>
								<div class="pull-right action-buttons">
									<a href="#"><svg class="glyph stroked pencil"><use xlink:href="#stroked-pencil"></use></svg></a>
									<a href="#" class="flag"><svg class="glyph stroked flag"><use xlink:href="#stroked-flag"></use></svg></a>
									<a href="#" class="trash"><svg class="glyph stroked trash"><use xlink:href="#stroked-trash"></use></svg></a>
								</div>
							</li>
							<li class="todo-list-item">
								<div class="checkbox">
									<svg class="glyph stroked calendar"><use xlink:href="#stroked-calendar"/></svg>
									<label for="checkbox">Project</label>
								</div>
								<div class="pull-right action-buttons">
									<a href="#"><svg class="glyph stroked pencil"><use xlink:href="#stroked-pencil"></use></svg></a>
									<a href="#" class="flag"><svg class="glyph stroked flag"><use xlink:href="#stroked-flag"></use></svg></a>
									<a href="#" class="trash"><svg class="glyph stroked trash"><use xlink:href="#stroked-trash"></use></svg></a>
								</div>
							</li>
                                                        <li class="todo-list-item">
								<div class="checkbox">
									<svg class="glyph stroked calendar"><use xlink:href="#stroked-calendar"/></svg>
									<label for="checkbox">Project</label>
								</div>
								<div class="pull-right action-buttons">
									<a href="#"><svg class="glyph stroked pencil"><use xlink:href="#stroked-pencil"></use></svg></a>
									<a href="#" class="flag"><svg class="glyph stroked flag"><use xlink:href="#stroked-flag"></use></svg></a>
									<a href="#" class="trash"><svg class="glyph stroked trash"><use xlink:href="#stroked-trash"></use></svg></a>
								</div>
							</li>
                                                        <li class="todo-list-item">
								<div class="checkbox">
									<svg class="glyph stroked calendar"><use xlink:href="#stroked-calendar"/></svg>
									<label for="checkbox">Project</label>
								</div>
								<div class="pull-right action-buttons">
									<a href="#"><svg class="glyph stroked pencil"><use xlink:href="#stroked-pencil"></use></svg></a>
									<a href="#" class="flag"><svg class="glyph stroked flag"><use xlink:href="#stroked-flag"></use></svg></a>
									<a href="#" class="trash"><svg class="glyph stroked trash"><use xlink:href="#stroked-trash"></use></svg></a>
								</div>
							</li>
                                                        <li class="todo-list-item">
								<div class="checkbox">
									<svg class="glyph stroked calendar"><use xlink:href="#stroked-calendar"/></svg>
									<label for="checkbox">Project</label>
								</div>
								<div class="pull-right action-buttons">
									<a href="#"><svg class="glyph stroked pencil"><use xlink:href="#stroked-pencil"></use></svg></a>
									<a href="#" class="flag"><svg class="glyph stroked flag"><use xlink:href="#stroked-flag"></use></svg></a>
									<a href="#" class="trash"><svg class="glyph stroked trash"><use xlink:href="#stroked-trash"></use></svg></a>
								</div>
							</li>
                                                        <li class="todo-list-item">
								<div class="checkbox">
									<svg class="glyph stroked calendar"><use xlink:href="#stroked-calendar"/></svg>
									<label for="checkbox">Project</label>
								</div>
								<div class="pull-right action-buttons">
									<a href="#"><svg class="glyph stroked pencil"><use xlink:href="#stroked-pencil"></use></svg></a>
									<a href="#" class="flag"><svg class="glyph stroked flag"><use xlink:href="#stroked-flag"></use></svg></a>
									<a href="#" class="trash"><svg class="glyph stroked trash"><use xlink:href="#stroked-trash"></use></svg></a>
								</div>
							</li>
                                                        <li class="todo-list-item">
								<div class="checkbox">
									<svg class="glyph stroked calendar"><use xlink:href="#stroked-calendar"/></svg>
									<label for="checkbox">Project</label>
								</div>
								<div class="pull-right action-buttons">
									<a href="#"><svg class="glyph stroked pencil"><use xlink:href="#stroked-pencil"></use></svg></a>
									<a href="#" class="flag"><svg class="glyph stroked flag"><use xlink:href="#stroked-flag"></use></svg></a>
									<a href="#" class="trash"><svg class="glyph stroked trash"><use xlink:href="#stroked-trash"></use></svg></a>
								</div>
							</li>
                                                        <li class="todo-list-item">
								<div class="checkbox">
									<svg class="glyph stroked calendar"><use xlink:href="#stroked-calendar"/></svg>
									<label for="checkbox">Project</label>
								</div>
								<div class="pull-right action-buttons">
									<a href="#"><svg class="glyph stroked pencil"><use xlink:href="#stroked-pencil"></use></svg></a>
									<a href="#" class="flag"><svg class="glyph stroked flag"><use xlink:href="#stroked-flag"></use></svg></a>
									<a href="#" class="trash"><svg class="glyph stroked trash"><use xlink:href="#stroked-trash"></use></svg></a>
								</div>
							</li>
						</ul>
					</div>
					<div class="panel-footer">
						
					</div>
				</div>
                    </div>
                </div>
             <div class="row">   
                <div class="col-lg-12">

                        <div class="portlet"><!-- /primary heading -->
                            <div class="portlet-heading">
                                <h3 class="portlet-title text-dark text-uppercase">
                                    Projects
                                </h3>
                                <div class="portlet-widgets">
                                    <a href="javascript:;" data-toggle="reload"><i class="ion-refresh"></i></a>
                                    <span class="divider"></span>
                                    <a data-toggle="collapse" data-parent="#accordion1" href="#portlet2" class="" aria-expanded="true"><i class="ion-minus-round"></i></a>
                                    <span class="divider"></span>
                                    <a href="#" data-toggle="remove"><i class="ion-close-round"></i></a>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                            <div id="portlet2" class="panel-collapse collapse in">
                                <div class="portlet-body">
                                    <div class="table-responsive">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>Label Projet</th>
                                                    <th>Date Debut</th>
                                                    <th>Date Cloture</th>
                                                    <th>Status</th>
                                                    <th>Plus</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>1</td>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td><span class="label label-info"></span></td>
                                                    <td></td>
                                                </tr>
                                                <tr>
                                                    <td>2</td>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td><span class="label label-success"></span></td>
                                                    <td></td>
                                                </tr>
                                                <tr>
                                                    <td>3</td>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td><span class="label label-success"></span></td>
                                                    <td></td>
                                                </tr>
                                               <tr>
                                                    <td>4</td>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td><span class="label label-success"></span></td>
                                                    <td></td>
                                                </tr>
                                               <tr>
                                                    <td>5</td>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td><span class="label label-success"></span></td>
                                                    <td></td>
                                                </tr>

                                                <tr>
                                                    <td>6</td>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td><span class="label label-success"></span></td>
                                                    <td></td>
                                                </tr>

                                                <tr>
                                                    <td>7</td>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td><span class="label label-success"></span></td>
                                                    <td></td>
                                                </tr>

                                               <tr>
                                                    <td>8</td>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td><span class="label label-success"></span></td>
                                                    <td></td>
                                                </tr>
                                                
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
             </div>
                
                <br>
                <br>
        
        
        
    </div> <!-- main -->
        
        
        
        
        
        
        <script src="https://cdn.jsdelivr.net/holder/2.9.0/holder.min.js"></script>
         <script src="assets/js/jquery-1.11.1.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/chart.min.js"></script>
	<script src="assets/js/chart-data.js"></script>
	<script src="assets/js/easypiechart.js"></script>
	<script src="assets/js/easypiechart-data.js"></script>
	<script src="assets/js/bootstrap-datepicker.js"></script>
    </body>
</html>
