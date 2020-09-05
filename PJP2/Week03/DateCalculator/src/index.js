const express = require('express'); 
  
/* Creates an Express application.  
   The express() function is a top-level  
   function exported by the express module. 
*/
const app = express(); 
const Pool = require('pg').Pool; 
const path = require('path');
  
const pool = new Pool(CREDENTIALS); 

const bodyParser = require('body-parser'); 
app.use(bodyParser.json()) 
app.use(bodyParser.urlencoded({ extended: false })); 
  
  
pool.connect((err, client, release) => { 
    if (err) { 
        return console.error( 
            'Error acquiring client', err.stack) 
    } 
    client.query('SELECT NOW()', (err, result) => { 
        release() 
        if (err) { 
            return console.error( 
                'Error executing query', err.stack) 
        } 
        console.log("Connected to Database !") 
    }) 
})

app.get('/', function(req, res) {
    res.sendFile(path.join(__dirname + '/html/home.html'));
});

app.get('/home', function(req, res) {
    res.sendFile(path.join(__dirname + '/html/home.html'));
});

app.get('/calculator', function(req, res) {
    res.sendFile(path.join(__dirname + '/html/calculator.html'));
});

app.post('/calculator-result', function(req, res) {

    let op_list = ["", "add_dates", "subtract_dates", "add_days", "add_weeks", "add_months", "get_day_of_week", "get_week_number", "natural_language_processor"];
    let op_val = op_list[parseInt(req['body']['operation'])]

    let query_string = "SELECT perform_operation('"+op_val+"', '"+req['body']['arg1']+"', '"+req['body']['arg2']+"');"
    console.log(query_string);

    pool.query(query_string) 
        .then(result => { 
            res.send({'ret_val':result.rows[0]['perform_operation']}) 
        }); 

    // res.send({'ret_val':'Invalid Query'});
});

const server = app.listen(3000, function () { 
    let host = server.address().address 
    let port = server.address().port 
    // Starting the Server at the port 3000 
}) 