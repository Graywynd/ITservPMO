<%-- 
    Document   : list_comptes
    Created on : 26 juil. 2016, 10:01:49
    Author     : saif
--%>

<%@page import="com.hibernate.Compte"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comptes</title>
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
                
                
                
         <!--       <div class="row">
                    <div class="col-lg-12">
				<h2>Comptes</h2>
			</div>
                </div>
                
                
                <hr style="width: 100%; color: #2aabd2; height: 1px; background-color: #d0e9c6;" />
                
                <div class="row" style="margin-top: 20px;" >
			
			<div class="col-md-4">
				<div class="panel panel-primary">
					<div class="panel-heading" style="background-color: #30a5ff; ">
                                            <div align="center">ITSERV</div>
					</div>
					<div class="panel-body" style="background-color:#dfdee3;">
                                            <div align="center"><a href="vuecompte.htm"><img class="img-circle" src="assets/img/logo-it-serv.jpg" width="140" height="140" alt="Card image cap"></a></div>
                                        </div>
                                    <div class="panel-footer" style="background-color:#30a5ff;">
                                        
                                    </div>
				</div>
			</div>
			
			<div class="col-md-4">
				<div class="panel panel-primary">
					<div class="panel-heading" style="background-color: #30a5ff; " >
                                            <div align="center">OOREDOO</div>
					</div>
					<div class="panel-body" style="background-color:#dfdee3;">
						 <div align="center"> <a href="vuecompte.htm"><img class="img-circle" src="assets/img/ooredoo-logo.jpg" width="140" height="140" alt="Card image cap"></a></div>					</div>
                                    <div class="panel-footer" style="background-color: #30a5ff; ">
                                        
                                    </div>
				</div>
			</div>
			
			<div class="col-md-4">
				<div class="panel panel-primary">
					<div class="panel-heading" style="background-color: #30a5ff; ">
                                            <div align="center">ABC.Co</div>
					</div>
					<div class="panel-body" style="background-color:#dfdee3;">
                                           <div align="center"> <a href="vuecompte.htm"><img class="img-circle" src="assets/img/abc-logo.png" width="140" height="140" alt="Card image cap"></a></div>
                                        </div>
                                    <div class="panel-footer" style="background-color: #30a5ff; ">
                                        
                                    </div>
				</div>
			</div>
			
		</div>
                
                <hr style="width: 100%; color: #2aabd2; height: 1px; background-color:#d0e9c6;" />
                
                <div class="row" style="margin-top: 20px; ">
			
			<div class="col-md-4">
				<div class="panel panel-primary">
					<div class="panel-heading" style="background-color: #30a5ff; ">
                                            <div align="center">HYDRO</div>
					</div>
					<div class="panel-body" style="background-color:#dfdee3;">
                                            <div align="center"><a href="vuecompte.htm"><img class="img-circle" src="assets/img/hydro-logo.png" width="140" height="140" alt="Card image cap"></a></div>
                                        </div>
                                    <div class="panel-footer" style="background-color: #30a5ff; ">
                                        
                                    </div>
				</div>
			</div>
			
			
			
			
		</div><!-- /.row --> 
                
		
         <br/>
         <br/>
                 <div class="row">
        <div class="col-xs-12  col-sm-6 col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading c-list">
                    <span class="title">Comptes</span>
                    <ul class="pull-right c-controls">
                        
                        <li><a href="#" class="hide-search" data-command="toggle-search" data-toggle="tooltip" data-placement="top" title="Toggle Search"><i class="fa fa-ellipsis-v"></i></a></li>
                    </ul>
                </div>
                
                <div class="row" style="display: none;">
                    <div class="col-xs-12">
                        <div class="input-group c-search">
                            <input type="text" class="form-control" id="contact-list-search">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="button"><span class="glyphicon glyphicon-search text-muted"></span></button>
                            </span>
                        </div>
                    </div>
                </div>
                
                <div id="custom-search-input">
						<div class="input-group col-md-12">
							<input id="search" type="text" class="form-control input-lg" placeholder="Chercher" />
							<span class="input-group-btn">
								<button class="btn btn-info btn-lg" type="button">
									<i class="glyphicon glyphicon-search"></i>
								</button>
							</span>
						</div>
                
                <ul class="list-group" id="contact-list">
                    <li class="list-group-item">
                        <div class="col-xs-12 col-sm-3">
                            <a href="vuecompte.htm"> <img src="assets/img/logo-it-serv.jpg" alt="Scott Stevens" class="img-responsive img-circle" /></a>
                        </div>
                        <div class="col-xs-12 col-sm-3">
                            <span class="name">ITSERV</span><br/>
                            <span class="glyphicon glyphicon-map-marker text-muted c-info" data-toggle="tooltip" title="Adresse"></span>
                            <span class="visible-xs"> <span class="text-muted">Adresse</span><br/></span>
                            <span class="glyphicon glyphicon-earphone text-muted c-info" data-toggle="tooltip" title="Tel"></span>
                            <span class="visible-xs"> <span class="text-muted">TEL</span><br/></span>
                            <span class="glyphicon glyphicon-comment text-muted c-info" data-toggle="tooltip" title="Email"></span>
                            <span class="visible-xs"> <span class="text-muted">Email</span><br/></span>
                        </div>
                           
                        <br/>
                        <br/>
                        <div class="col-xs-12 col-sm-6">
                            
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec eget rutrum purus. Donec hendrerit ante ac metus sagittis elementum. Mauris feugiat nisl sit amet neque luctus, a tincidunt odio auctor. </p>
                                                                
                        </div>
                        <div class="clearfix"></div>
                    </li>
                    <li class="list-group-item">
                        <div class="col-xs-12 col-sm-3">
                            <a href="vuecompte.htm">   <img src="assets/img/ooredoo-logo.jpg" alt="Seth Frazier" class="img-responsive img-circle" /></a>
                        </div>
                        <div class="col-xs-12 col-sm-3">
                            <span class="name">OOREDOO</span><br/>
                            <span class="glyphicon glyphicon-map-marker text-muted c-info" data-toggle="tooltip" title="Adresse"></span>
                            <span class="visible-xs"> <span class="text-muted">Adresse</span><br/></span>
                            <span class="glyphicon glyphicon-earphone text-muted c-info" data-toggle="tooltip" title="Tel"></span>
                            <span class="visible-xs"> <span class="text-muted">TEL</span><br/></span>
                            <span class="glyphicon glyphicon-comment text-muted c-info" data-toggle="tooltip" title="Email"></span>
                            <span class="visible-xs"> <span class="text-muted">Email</span><br/></span>
                        </div>
                        <br/>
                        <br/>
                        <div class="col-xs-12 col-sm-6">
                            
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec eget rutrum purus. Donec hendrerit ante ac metus sagittis elementum. Mauris feugiat nisl sit amet neque luctus, a tincidunt odio auctor. </p>
                                                                
                        </div>
                        <div class="clearfix"></div>
                    </li>
                    <li class="list-group-item">
                        <div class="col-xs-12 col-sm-3">
                            <a href="vuecompte.html"> <img src="assets/img/abc-logo.png" alt="Jean Myers" class="img-responsive img-circle" /></a>
                        </div>
                        <div class="col-xs-12 col-sm-3">
                            <span class="name">ABC.CO</span><br/>
                            <span class="glyphicon glyphicon-map-marker text-muted c-info" data-toggle="tooltip" title="Adresse"></span>
                            <span class="visible-xs"> <span class="text-muted">Adresse</span><br/></span>
                            <span class="glyphicon glyphicon-earphone text-muted c-info" data-toggle="tooltip" title="Tel"></span>
                            <span class="visible-xs"> <span class="text-muted">TEL</span><br/></span>
                            <span class="glyphicon glyphicon-comment text-muted c-info" data-toggle="tooltip" title="Email"></span>
                            <span class="visible-xs"> <span class="text-muted">Email</span><br/></span>
                        </div>
                        <br/>
                        <br/>
                        <div class="col-xs-12 col-sm-6">
                            
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec eget rutrum purus. Donec hendrerit ante ac metus sagittis elementum. Mauris feugiat nisl sit amet neque luctus, a tincidunt odio auctor. </p>
                                                                
                        </div>
                        <div class="clearfix"></div>
                    </li>
                    <li class="list-group-item">
                        <div class="col-xs-12 col-sm-3">
                            <a href="vuecompte.htm">   <img src="assets/img/hydro-logo.png" alt="Todd Shelton" class="img-responsive img-circle" /></a>
                        </div>
                        <div class="col-xs-12 col-sm-3">
                            <span class="name">Hydro</span><br/>
                            <span class="glyphicon glyphicon-map-marker text-muted c-info" data-toggle="tooltip" title="Adresse"></span>
                            <span class="visible-xs"> <span class="text-muted">Adresse</span><br/></span>
                            <span class="glyphicon glyphicon-earphone text-muted c-info" data-toggle="tooltip" title="Tel"></span>
                            <span class="visible-xs"> <span class="text-muted">Tel</span><br/></span>
                            <span class="glyphicon glyphicon-comment text-muted c-info" data-toggle="tooltip" title="Email"></span>
                            <span class="visible-xs"> <span class="text-muted">Email</span><br/></span>
                        </div>
                        <br/>
                        <br/>
                        <div class="col-xs-12 col-sm-6">
                            
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec eget rutrum purus. Donec hendrerit ante ac metus sagittis elementum. Mauris feugiat nisl sit amet neque luctus, a tincidunt odio auctor. </p>
                                                                
                        </div>
                        <div class="clearfix"></div>
                    </li>
                    
                    
                   
                </ul>
            </div>
            </div>
        </div>
	</div>
              
                
         </div> <!-- main -->
        
         
         <script>
             $(function(){
	$('#search').keyup(function(){	
		var current_query = $('#search').val().toLowerCase();
		if (current_query !== "") {
			$(".list-group li").hide();
			$(".list-group li").each(function(){
				var current_keyword = $(this).text().toLowerCase();
                                 
                                   if (current_keyword.indexOf(current_query) >=0) {
					$(this).show();    	 	
				};
			});    	
		} else {
			$(".list-group li").show();
		};
	});
});
         </script>
         
         
         <script>
             $(function () {
    /* BOOTSNIPP FULLSCREEN FIX */
    if (window.location == window.parent.location) {
        $('#back-to-bootsnipp').removeClass('hide');
    }
    
    
    $('[data-toggle="tooltip"]').tooltip();
    
    $('#fullscreen').on('click', function(event) {
        event.preventDefault();
        window.parent.location = "http://bootsnipp.com/iframe/4l0k2";
    });
    $('a[href="#cant-do-all-the-work-for-you"]').on('click', function(event) {
        event.preventDefault();
        $('#cant-do-all-the-work-for-you').modal('show');
    })
    
    $('[data-command="toggle-search"]').on('click', function(event) {
        event.preventDefault();
        $(this).toggleClass('hide-search');
        
        if ($(this).hasClass('hide-search')) {        
            $('.c-search').closest('.row').slideUp(100);
        }else{   
            $('.c-search').closest('.row').slideDown(100);
        }
    })
    
    $('#contact-list').searchable({
        searchField: '#contact-list-search',
        selector: 'li',
        childSelector: '.col-xs-12',
        show: function( elem ) {
            elem.slideDown(100);
        },
        hide: function( elem ) {
            elem.slideUp( 100 );
        }
    })
});

         </script>
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
