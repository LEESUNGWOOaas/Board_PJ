<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>


<script src="https://cdn.amcharts.com/lib/4/core.js"></script>
<script src="https://cdn.amcharts.com/lib/4/charts.js"></script>
<script src="https://cdn.amcharts.com/lib/4/themes/kelly.js"></script>
<script src="https://cdn.amcharts.com/lib/4/themes/animated.js"></script>





<div class="header">
	<h1 class="page-header">
		<small>Main</small>
	</h1>
</div>


<div id="page-inner">

	<div class="panel panel-default">

		<div class="panel-body">
			<div class="row">
				<div class="col-sm-4">
					<div class="table-responsive">
						<table class="table table-bordered">
							<colgroup>
								<col width="50%">
								<col width="25%">
								<col width="25%">
							</colgroup>
							<thead>
								<tr>
									<th>항목</th>
									&nbsp;
									<th>금일건수&nbsp;&nbsp;</th>
									<th>전체건수</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach var="item" items="${chart1}">
									<tr>
										<td>${item.bname }</td>
										<td>${item.today}</td>
										<td>${item.total}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

					</div>
				</div>
				<div class="col-sm-4">
					<div id="chartdiv1"></div>
				</div>
			</div>

			<hr />

			<div class="row">
				<div class="col-sm-4">
					<div class="table-responsive">
						<table class="table table-bordered">
							<colgroup>
								<col width="50%">
								<col width="25%">
								<col width="25%">
							</colgroup>
							<thead>
								<tr>
									<th>항목</th>
									&nbsp;
									<th>금일건수&nbsp;&nbsp;</th>
									<th>전체건수</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach var="item" items="${chart2}">
									<tr>
										<td>${item.manager}</td>
										<td>${item.today}</td>
										<td>${item.total}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

					</div>
				</div>
				<div class="col-sm-4">
					<div id="chartdiv2"></div>
				</div>
			</div>


		</div>
	</div>
</div>


<script>
$(function(){
	activeMenu('/admin/bbs/bbs012/list');
});

am4core.ready(function() {

	// Themes begin
	am4core.useTheme(am4themes_kelly);
	am4core.useTheme(am4themes_animated);
	// Themes end
    am4core.addLicense("ch-custom-attribution");
	// Create chart instance
	var chart = am4core.create("chartdiv1", am4charts.PieChart);

	//chart.data = [];
	<c:forEach var="item" items="${chart1}">
	chart.data.push({"category":"${item.bname}", "litres":${item.total}});
	</c:forEach>

	 <!--Add and configure Series-->
	var pieSeries = chart.series.push(new am4charts.PieSeries());
	pieSeries.dataFields.value = "litres";
	pieSeries.dataFields.category = "category";
	pieSeries.slices.template.stroke = am4core.color("#fff");
	pieSeries.slices.template.strokeOpacity = 1;
	// This creates initial animation
	pieSeries.hiddenState.properties.opacity = 1;
	pieSeries.hiddenState.properties.endAngle = -90;
	pieSeries.hiddenState.properties.startAngle = -90;
	chart.hiddenState.properties.radius = am4core.percent(0);
}); // end am4core.ready()

am4core.ready(function() {

	// Themes begin
	am4core.useTheme(am4themes_kelly);
	am4core.useTheme(am4themes_animated);
	// Themes end
    am4core.addLicense("ch-custom-attribution");
	// Create chart instance
	var chart = am4core.create("chartdiv2", am4charts.PieChart);

	//chart.data = [];
	<c:forEach var="item" items="${chart2}">
	chart.data.push({"category":"${item.manager}", "litres":${item.total}});
	</c:forEach>


	var pieSeries = chart.series.push(new am4charts.PieSeries());
	pieSeries.dataFields.value = "litres";
	pieSeries.dataFields.category = "category";
	pieSeries.slices.template.stroke = am4core.color("#fff");
	pieSeries.slices.template.strokeOpacity = 1;
	// This creates initial animation
	pieSeries.hiddenState.properties.opacity = 1;
	pieSeries.hiddenState.properties.endAngle = -90;
	pieSeries.hiddenState.properties.startAngle = -90;
	chart.hiddenState.properties.radius = am4core.percent(0);
}); // end am4core.ready()
	 
	 
	
	</script>

