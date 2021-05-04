<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
  <%@ include file="../../common/top_Include.jsp"%>
  <%
  ArrayList<HashMap<String, Object>> list =
  (ArrayList<HashMap<String, Object>>) request.getAttribute("static");
  ArrayList<HashMap<String, Object>> list2 =
  (ArrayList<HashMap<String, Object>>) request.getAttribute("static2");
  ArrayList<HashMap<String, Object>> list3 =
  (ArrayList<HashMap<String, Object>>) request.getAttribute("static3");
  ArrayList<HashMap<String, Object>> list4 =
  (ArrayList<HashMap<String, Object>>) request.getAttribute("static4");
  ArrayList<HashMap<String,Object>> list5 =
  (ArrayList<HashMap<String,Object>>) request.getAttribute("static5");
  ArrayList<HashMap<String,Object>> list6 =
  (ArrayList<HashMap<String,Object>>) request.getAttribute("static6");
  ArrayList<HashMap<String,Object>> list7 =
  (ArrayList<HashMap<String,Object>>) request.getAttribute("static7");
  ArrayList<HashMap<String,Object>> list8 =
  (ArrayList<HashMap<String,Object>>) request.getAttribute("static8");

  %>
<!DOCTYPE html>
<html>
<%@ include file="../../common/inner_admin_include.jsp" %>
  <head>
  <script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);



      <%System.out.print( list.get(0).get("reason1"));%>



      function drawChart() {
////////////////////////후원끊는이유///////////////////////////////////////////
        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
          ['금전적 부담',   <%=list4.get(0).get("can1")%> ],
          ['보호소에 대한 불만',   <%=list4.get(0).get("can2")%> ],
          ['타 사이트 이용',  <%=list4.get(0).get("can3")%> ],
          ['기타',  <%=list4.get(0).get("can4")%> ],

        ]);

        var options = {
          title: '후원을 끊는 이유'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);


        ////////////////////////////월별가입한 회원수//////////////////////////////
        var data = google.visualization.arrayToDataTable([

          ['월', '회원수'],
          ['1월',  <%=list5.get(0).get("enroll1") %>],
          ['2월',  <%=list5.get(0).get("enroll2") %>],
          ['3월',  <%=list5.get(0).get("enroll3") %>],
          ['4월',  <%=list5.get(0).get("enroll4") %>],
          ['5월',  <%=list5.get(0).get("enroll5") %>],
          ['6월',  <%=list5.get(0).get("enroll6") %>],
          ['7월',  <%=list5.get(0).get("enroll7") %>],
          ['8월',  <%=list5.get(0).get("enroll8") %>],
          ['9월',  <%=list5.get(0).get("enroll9") %>],
          ['10월', <%=list5.get(0).get("enroll10") %>],
          ['11월',  <%=list5.get(0).get("enroll11") %>],
          ['12월',  <%=list5.get(0).get("enroll12") %>]

        ]);

        var options = {
          title: '월별 가입한 회원 수',
          curveType: 'function',
          legend: { position: 'bottom' }
        };

        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

        chart.draw(data, options);


          //////////////////////기부금액///////////////////////
          var data = google.visualization.arrayToDataTable([
              ['월별', '기부금',],
              ['1월', <%= list7.get(0).get("sup1")%>],
              ['2월', <%= list7.get(0).get("sup2")%>],
              ['3월', <%= list7.get(0).get("sup3")%>],
              ['4월', <%= list7.get(0).get("sup4")%>],
              ['5월', <%= list7.get(0).get("sup5")%>],
              ['6월', <%= list7.get(0).get("sup6")%>],
              ['7월', <%= list7.get(0).get("sup7")%>],
              ['8월', <%= list7.get(0).get("sup8")%>],
              ['9월', <%= list7.get(0).get("sup9")%>],
              ['10월', <%= list7.get(0).get("sup10")%>],
              ['11월', <%= list7.get(0).get("sup11")%>],
              ['12월', <%= list7.get(0).get("sup12")%>]
            ]);

            var options = {
              title: '기부 금액',
              chartArea: {width: '50%'},

            };

            var chart = new google.visualization.BarChart(document.getElementById('chart_div'));

            chart.draw(data, options);


          ///////////////////////////회원 탈퇴 사유/////////////////////////////////////////////////////
            var data = google.visualization.arrayToDataTable([
                ['T', 'H'],
                ['서비스 이용 불필요',      <%=list.get(0).get("reason1")%> ],
                ['사이트 불신',       <%=list.get(0).get("reason2")%> ],
                ['재가입',   <%=list.get(0).get("reason3")%> ],
                ['컨텐츠 부족',   <%=list.get(0).get("reason4")%> ],
                ['기타',  <%=list.get(0).get("reason5")%> ],

              ]);

              var options = {
                title: '회원탈퇴사유'
              };

              var chart = new google.visualization.PieChart(document.getElementById('piechart2'));

              chart.draw(data, options);

              ///////////////분양 많이 받은 견종/////////////////////
              var data = google.visualization.arrayToDataTable([
                  ['T', 'H'],
                  ['말티즈',   <%=list2.get(0).get("dog_kind1")%> ],
                  ['코카스파니엘',  <%=list2.get(0).get("dog_kind2")%> ],
                  ['믹스',  <%=list2.get(0).get("dog_kind3")%> ],
                  ['푸들',  <%=list2.get(0).get("dog_kind4")%> ],
                  ['요크셔테리어',  <%=list2.get(0).get("dog_kind5")%> ],
                  ['웰시코기',  <%=list2.get(0).get("dog_kind6")%> ],
                  ['포메라니안',  <%=list2.get(0).get("dog_kind7")%> ],
                  ['스피치',  <%=list2.get(0).get("dog_kind8")%> ],
                  ['닥스훈트',  <%=list2.get(0).get("dog_kind9")%> ],
                  ['사모예드',  <%=list2.get(0).get("dog_kind10")%> ],
                  ['골든리트리버',  <%=list2.get(0).get("dog_kind11")%> ],
                  ['허스키',  <%=list2.get(0).get("dog_kind12")%> ],
                  ['쉐퍼드',  <%=list2.get(0).get("dog_kind13")%> ]


                ]);

                var options = {
                  title: '분양 견종'
                };

                var chart = new google.visualization.PieChart(document.getElementById('piechart3'));

                chart.draw(data, options);



                /////////////////////////////분양강아지나이/////////////////////////
                var data = google.visualization.arrayToDataTable([

                    ['마리', '마리'],
                    ['0개월~6개월',  <%= list6.get(0).get("dogAge1")%> ],
                    ['6개월~1년',   <%= list6.get(0).get("dogAge2")%>],
                    ['1년~5년',  <%= list6.get(0).get("dogAge3")%>],
                    ['5년~10년',  <%= list6.get(0).get("dogAge4")%>],
                    ['10년이상',  <%= list6.get(0).get("dogAge5")%>],

                  ]);

                  var options = {
                    title: '분양견 나이',
                    curveType: 'function',
                    legend: { position: 'bottom' }
                  };

                  var chart = new google.visualization.LineChart(document.getElementById('curve_chart2'));

                  chart.draw(data, options);

                  ///////////////////////////////////기부물풀 목록//////////////////
                  var data = google.visualization.arrayToDataTable([
                      ['목록', '기부물품양',],
                      ['사료 및 간식', <%= list8.get(0).get("C1")%>],
                      ['이불 및 담요', <%= list8.get(0).get("C2")%>],
                      ['건강 용품', <%= list8.get(0).get("C3")%>],
                      ['장난감 및 의류', <%= list8.get(0).get("C4")%>]


                    ]);

                    var options = {
                      title: '기부 금액',
                      chartArea: {width: '50%'},

                    };

                    var chart = new google.visualization.BarChart(document.getElementById('chart_div2'));

                    chart.draw(data, options);

                    /////////////////////////가입경로//////////////////////
                    var data = google.visualization.arrayToDataTable([
                        ['T', 'H'],
                        ['sns',     <%=list3.get(0).get("root1")%>],
                        ['검색',      <%=list3.get(0).get("root2")%>],
                        ['광고',  <%=list3.get(0).get("root3")%>],
                        ['지인추천',  <%=list3.get(0).get("root4")%>],
                        ['기타', <%=list3.get(0).get("root5")%>],



                      ]);

                      var options = {
                        title: '회원 가입 경로'
                      };

                      var chart = new google.visualization.PieChart(document.getElementById('piechart4'));

                      chart.draw(data, options);
                      /////////////별점////////////////////

        }

    </script>
  </head>
  <body>
    <table>
       <tr>
          <td>   <div id="piechart" style="width: 700px; height: 400px;"></div></td>
          <td><div id="curve_chart" style="width:700px; height: 400px;"></div></td>
       </tr>
       <tr>
          <td><div id="chart_div" style="width: 700px; height: 400px;"></div></td>
          <td><div id="piechart2" style="width: 700px; height: 400px;"></div></td>
       </tr>
       <tr>
          <td><div id="piechart3" style="width: 700px; height: 400px;"></div></td>
          <td><div id="curve_chart2" style="width: 700px; height: 400px;"></div></td>
       </tr>
       <tr>
          <td><div id="chart_div2" style="width: 700px; height: 400px;"></td>
          <td><div id="piechart4" style="width: 700px; height: 400px;"></td>
       </tr>
    </table>



     <%@ include file="../../common/bottom_Include.jsp"%>

  </body>


</html>