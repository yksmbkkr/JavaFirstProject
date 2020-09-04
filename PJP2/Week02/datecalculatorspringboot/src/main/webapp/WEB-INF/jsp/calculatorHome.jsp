<%--
  Created by IntelliJ IDEA.
  User: yashk
  Date: 04-09-2020
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DateTimeCalculator</title>
    <style>
        input{
            margin: 5px 5px 5px 5px;
        }
    </style>
    <link href = "https://code.jquery.com/ui/1.12.1/themes/ui-lightness/jquery-ui.css" rel = "stylesheet">
</head>
<body>
<h1>Date Time Calculator</h1>
<br>
<p>Available Options - </p>
<div id="options" style="display: none;"></div>
<div id="date-form-div" style="display: none;">
    <p id="date-form-p">
        <form id="date-form"></form>
    </p>
</div>
<div id="result-div"></div>


<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script src = "https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
    var CALC_OPTIONS = ['add dates', 'subtract dates', 'add or subtract days from a specific date' ,
        'add or subtract weeks from a specific date', 'add or subtract months from a specific date',
        'determine the Day of the Week for a specific date', 'determine the Week Number for a specific date',
        'get date from a natural language string']
    var dateinput1 = '<input type="text" id="date1" name="date1" />'
    var dateinput2 = '<input type="text" id="date2" name="date2" />'
    var quantity = '<input type="number" id="quantity" name="quantity" step="1">'
    var txt = '<input type="text" id="lan_txt" name="lan_txt">'

    $(document).ready(function() {
        $('#options').html('');
        console.log("init");
        CALC_OPTIONS.forEach(function (curr, idx) {
           html_txt = '<p><button type=button onclick="selectOption(' + idx + ', \'' + curr + '\')">'+curr+'</button></p>'
            $('#options').append(html_txt);
        });
        showMenu(true);
        showForm(false);
    });

    function showMenu(opt){
        showForm(false);
      if(opt){
          $('#options').show();
      } else {
          $('#options').hide();
      }
    };

    function showForm(opt){
        if(opt){
            $('#date1').datepicker({
                changeMonth: true,
                changeYear: true,
                dateFormat: 'dd--mm--yy'
            });
            $('#date2').datepicker({
                changeMonth: true,
                changeYear: true,
                dateFormat: "dd--mm--yy"
            });
            $('#date-form-div').show();
        } else {
            $('#date-form-div').hide();
        }
    };

    function submitButton(opt){
        if (opt){
            $('#submit-button').prop('disabled', false);
            $('#submit-button').html('Submit');
        } else {
            $('#submit-button').prop('disabled', true);
            $('#submit-button').html('Waiting for result...');
        }
    }

    function selectOption(opt, ops){
        opt = parseInt(opt)+1;
        showMenu(false);
        let date_form = $('#date-form')
        date_form.html('');
        date_form.append('<br><br><button type=button onclick="showMenu(true)">Show Menu</button><br>');
        date_form.append('<br><br>performing - '+ops+'<br>');
        date_form.append('<input type="hidden" id="opt" name="opt" value="'+opt+'">')
        switch (opt){
            case 1:
                date_form.append('<br> Select Date 1 <br>')
                date_form.append(dateinput1)
                date_form.append('<br> Select Date 2 <br>')
                date_form.append(dateinput2)
                break;
            case 2:
                date_form.append('<br> Select Date 1 <br>')
                date_form.append(dateinput1)
                date_form.append('<br> Select Date 2 <br>')
                date_form.append(dateinput2)
                break;
            case 3:
                date_form.append('<br> Select Date <br>')
                date_form.append(dateinput1)
                date_form.append('<br> Days to add or subtract <br>')
                date_form.append(quantity)
                break;
            case 4:
                date_form.append('<br> Select Date <br>')
                date_form.append(dateinput1)
                date_form.append('<br> Weeks to add or subtract <br>')
                date_form.append(quantity)
                break;
            case 5:
                date_form.append('<br> Select Date <br>')
                date_form.append(dateinput1)
                date_form.append('<br> Months to add or subtract <br>')
                date_form.append(quantity)
                break;
            case 6:
                date_form.append('<br> Select Date <br>')
                date_form.append(dateinput1)
                break;
            case 7:
                date_form.append('<br> Select Date <br>')
                date_form.append(dateinput1)
                break;
            case 8:
                date_form.append('<br> Input String <br>')
                date_form.append(txt)
                break;

        }
        date_form.append('<br><br><button id="submit-button" type=button onclick="submitAction()">Submit</button><br><br>');
        showForm(true);
    }

    function submitAction(){
        let empty_length = $('input').filter(function() {
            return this.value == '';
        }).length;
        if (empty_length !== 0){
            $('#date-form').append("<br><br>FILL ALL FIELDS<br><br>");
            console.log(empty_length);
            return;
        }
        let input_arr = []
        $('input').each(function (){
            console.log($(this).val())
            input_arr.push(String($(this).val()).replace(/--/g, " "))
        })
        if (input_arr.length === 2){
            input_arr.push('0')
        }

        let post_json = {
            'operation':input_arr[0],
            'arg1':input_arr[1],
            'arg2':input_arr[2]
        }

        submitButton(false);

        $.ajax({
            data: post_json,
            type: 'POST',
            url: '/api/calculate/date-calculator-result',
            success: function(data,status) {
                data = JSON.parse(data);
                $('#result-div').append('<p>Requested operation - '+CALC_OPTIONS[parseInt(input_arr[0])-1] +
                    '; with inputs '+input_arr[1]+', '+input_arr[2]+'; Result Recieved - '+data['ret_val']+' ! </p>')
                submitButton(true);
            },
            error: function (data,status) {
                $('#result-div').append('<p>Requested operation - '+CALC_OPTIONS[parseInt(input_arr[0])-1] +
                    '; with inputs '+input_arr[1]+', '+input_arr[2]+'; Result Recieved - INTERNAL SERVER ERROR ! </p>')
                submitButton(true);
            }
        });

    }
</script>

</body>
</html>
