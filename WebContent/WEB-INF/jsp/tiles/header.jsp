<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="navbar navbar-default navbar-fixedtop">
	<div class="container-fluid" style="vertical-align: middle;">
		<div class="navbar-header">
			<a class="navbar-brand" href="/ReviewSurvey/review/index">Spring
				Tiles</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="/ReviewSurvey/review/index"><spring:message code="header.nav.home"></spring:message></a></li>
		</ul>
		<div class="navbar-right" style="vertical-align: middle;">
			<a href="?locale=ja_JP">JP</a>/
			<a href="?locale=en_US">US</a>
		</div>
	</div>
</div>
<script type="text/javascript">
    $(function() {
        // this will get the full URL at the address bar
        var url = window.location.href;

        // passes on every "a" tag
        $(".navbar a").each(function() {
            // checks if its the same on the address bar
            if (url == (this.href)) {
                $(this).closest("li").addClass("active");
                //for making parent of submenu active
               $(this).closest("li").parent().parent().addClass("active");
            }
        });
    });        
</script>