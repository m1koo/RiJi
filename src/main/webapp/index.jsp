<%--
  Created by IntelliJ IDEA.
  User: zoudehong
  Date: 2017/2/27
  Time: 下午3:56
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入jstl--%>
<%@ include file="WEB-INF/jsp/common/tag.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@include file="WEB-INF/jsp/common/head.jsp" %>
</head>
<body>


<div class="jumbotron">
    <h3>税率转换</h3>
</div>

<div class="input-group input-group-lg">
    <span class="input-group-addon" >金额</span>
    <input type="number" class="form-control"
           oninput="moneyChange(event)" onporpertychange="moneyChange(event)"
           id="id_input_money" placeholder="" aria-describedby="sizing-addon1">
</div>


<div class="input-group input-group-lg">
    <span class="input-group-addon" >税率 %</span>
    <input type="number" class="form-control" id="id_input_taxrate" value="6" placeholder="" aria-describedby="sizing-addon1">
</div>


<div class="input-group input-group-lg">
    <span class="input-group-addon" >税额</span>
    <input type="number" class="form-control"
           oninput="taxAmountChange(event)" onporpertychange="taxAmountChange(event)"
           id="id_input_amount_of_tax" placeholder="" aria-describedby="sizing-addon1">
</div>
<div class="input-group input-group-lg">
    <span class="input-group-addon" >总计</span>
    <input type="number" class="form-control"
           oninput="sumChange(event)" onporpertychange="sumChange(event)"
           id="id_input_sum" placeholder="" aria-describedby="sizing-addon1">
</div>

<script type="text/javascript">
    function moneyChange(e){
        var money = document.getElementById("id_input_money")

        var taxRate = document.getElementById("id_input_taxrate")

        var amountOfTax = document.getElementById("id_input_amount_of_tax")

        var sum = document.getElementById("id_input_sum")

        var taxRateValue = parseFloat(taxRate.value) * 0.01

        var sumValue = parseFloat(money.value)*(1+taxRateValue)

        amountOfTax.value = sumValue - parseFloat(money.value)

        sum.value = sumValue
    }
    function taxAmountChange(e){
        var money = document.getElementById("id_input_money")

        var taxRate = document.getElementById("id_input_taxrate")

        var amountOfTax = document.getElementById("id_input_amount_of_tax")

        var sum = document.getElementById("id_input_sum")

        var taxRateValue = parseFloat(taxRate.value) * 0.01

        var moneyValue = parseFloat(amountOfTax.value)/taxRateValue

        var sumValue = parseFloat(moneyValue) + parseFloat(amountOfTax.value)

        money.value = moneyValue

        sum.value = sumValue
    }

    function sumChange(e){
        var money = document.getElementById("id_input_money")

        var taxRate = document.getElementById("id_input_taxrate")

        var amountOfTax = document.getElementById("id_input_amount_of_tax")

        var sum = document.getElementById("id_input_sum")

        var taxRateValue = parseFloat(taxRate.value) * 0.01

        var amountOfTaxValue = sum.value*(1/(1+taxRateValue))*taxRateValue

        var moneyValue = parseFloat(sum.value) - parseFloat(amountOfTaxValue)

        money.value = moneyValue

        amountOfTax.value = amountOfTaxValue
    }
</script>

</body>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>

</html>
