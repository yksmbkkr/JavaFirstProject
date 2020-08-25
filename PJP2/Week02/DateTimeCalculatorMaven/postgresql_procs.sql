CREATE OR REPLACE FUNCTION add_dates (arg1 varchar, arg2 varchar)
  RETURNS varchar
AS $$
    d1 = str(arg1).strip().split(' ')
    d2 = str(arg2).strip().split(' ')
    d1.reverse()
    d2.reverse()
    d1 = [int(x) for x in d1]
    d2 = [int(x) for x in d2]
    if not (len(d1) == 3 and len(d2) == 3):
        raise ValueError("Dates must be in format day month year e.g. 25 12 2020")
    import datetime
    from dateutil.relativedelta import relativedelta
    d1 = datetime.datetime(*d1)
    d1 = d1 + relativedelta(years=+d2[0])
    d1 = d1 + relativedelta(months=+d2[1])
    d1 = d1 + relativedelta(days=+d2[2])
    query_string = "INSERT INTO date_operations (argument1, argument2, operation, result) VALUES ('{argument1}', '{argument2}', '{operation}', '{result}');".format(argument1 = arg1, argument2 = arg2, operation = "add_dates", result = d1.strftime("%d %B %Y"))
    plpy.execute(query_string)
    return d1.strftime("%d %B %Y")
$$ LANGUAGE plpython3u;

CREATE OR REPLACE FUNCTION subtract_dates (arg1 varchar, arg2 varchar)
  RETURNS varchar
AS $$
    d1 = str(arg1).strip().split(' ')
    d2 = str(arg2).strip().split(' ')
    d1.reverse()
    d2.reverse()
    d1 = [int(x) for x in d1]
    d2 = [int(x) for x in d2]
    if not (len(d1) == 3 and len(d2) == 3):
        raise ValueError("Dates must be in format day month year e.g. 25 12 2020")
    import datetime
    from dateutil.relativedelta import relativedelta
    d1 = datetime.datetime(*d1)
    d2 = datetime.datetime(*d2)
    if d1>d2:
        diff = relativedelta(d1, d2)
    else:
        diff = relativedelta(d2, d1)

    result = str(diff.years) + " Years, "+str(diff.months)+" Months and "+str(diff.days)+" Days"

    query_string = "INSERT INTO date_operations (argument1, argument2, operation, result) VALUES ('{argument1}', '{argument2}', '{operation}', '{result}');".format(argument1 = arg1, argument2 = arg2, operation = "subtract_dates", result = result)
    plpy.execute(query_string)

    return result
$$ LANGUAGE plpython3u;

CREATE OR REPLACE FUNCTION add_weeks (arg1 varchar, arg2 varchar)
  RETURNS varchar
AS $$
    d1 = str(arg1).strip().split(' ')
    d1.reverse()
    d1 = [int(x) for x in d1]
    if not (len(d1) == 3):
        raise ValueError("Dates must be in format day month year e.g. 25 12 2020")
    import datetime
    from dateutil.relativedelta import relativedelta
    d1 = datetime.datetime(*d1)
    d1 = d1 + relativedelta(days=+(int(arg2)*7))
    query_string = "INSERT INTO date_operations (argument1, argument2, operation, result) VALUES ('{argument1}', '{argument2}', '{operation}', '{result}');".format(argument1 = arg1, argument2 = arg2, operation = "add_weeks", result = d1.strftime("%d %B %Y"))
    plpy.execute(query_string)

    return d1.strftime("%d %B %Y")
$$ LANGUAGE plpython3u;

CREATE OR REPLACE FUNCTION add_months (arg1 varchar, arg2 varchar)
  RETURNS varchar
AS $$
    d1 = str(arg1).strip().split(' ')
    d1.reverse()
    d1 = [int(x) for x in d1]
    if not (len(d1) == 3):
        raise ValueError("Dates must be in format day month year e.g. 25 12 2020")
    import datetime
    from dateutil.relativedelta import relativedelta
    d1 = datetime.datetime(*d1)
    d1 = d1 + relativedelta(months=+int(arg2))
    query_string = "INSERT INTO date_operations (argument1, argument2, operation, result) VALUES ('{argument1}', '{argument2}', '{operation}', '{result}');".format(argument1 = arg1, argument2 = arg2, operation = "add_months", result = d1.strftime("%d %B %Y"))
    plpy.execute(query_string)

    return d1.strftime("%d %B %Y")
$$ LANGUAGE plpython3u;

CREATE OR REPLACE FUNCTION add_years (arg1 varchar, arg2 varchar)
  RETURNS varchar
AS $$
    d1 = str(arg1).strip().split(' ')
    d1.reverse()
    d1 = [int(x) for x in d1]
    if not (len(d1) == 3):
        raise ValueError("Dates must be in format day month year e.g. 25 12 2020")
    import datetime
    from dateutil.relativedelta import relativedelta
    d1 = datetime.datetime(*d1)
    d1 = d1 + relativedelta(years=+int(arg2))
    query_string = "INSERT INTO date_operations (argument1, argument2, operation, result) VALUES ('{argument1}', '{argument2}', '{operation}', '{result}');".format(argument1 = arg1, argument2 = arg2, operation = "add_years", result = d1.strftime("%d %B %Y"))
    plpy.execute(query_string)

    return d1.strftime("%d %B %Y")
$$ LANGUAGE plpython3u;

CREATE OR REPLACE FUNCTION add_days (arg1 varchar, arg2 varchar)
  RETURNS varchar
AS $$
    d1 = str(arg1).strip().split(' ')
    d1.reverse()
    d1 = [int(x) for x in d1]
    if not (len(d1) == 3):
        raise ValueError("Dates must be in format day month year e.g. 25 12 2020")
    import datetime
    from dateutil.relativedelta import relativedelta
    d1 = datetime.datetime(*d1)
    d1 = d1 + relativedelta(days=+int(arg2))
    query_string = "INSERT INTO date_operations (argument1, argument2, operation, result) VALUES ('{argument1}', '{argument2}', '{operation}', '{result}');".format(argument1 = arg1, argument2 = arg2, operation = "add_days", result = d1.strftime("%d %B %Y"))
    plpy.execute(query_string)

    return d1.strftime("%d %B %Y")
$$ LANGUAGE plpython3u;

CREATE OR REPLACE FUNCTION get_week_number (arg1 varchar, arg2 varchar default '0')
  RETURNS varchar
AS $$
    d1 = str(arg1).strip().split(' ')
    d1.reverse()
    d1 = [int(x) for x in d1]
    if not (len(d1) == 3):
        raise ValueError("Dates must be in format day month year e.g. 25 12 2020")
    import datetime
    from dateutil.relativedelta import relativedelta
    d1 = datetime.date(*d1)
    result = str(d1.isocalendar()[1])
    query_string = "INSERT INTO date_operations (argument1, argument2, operation, result) VALUES ('{argument1}', '{argument2}', '{operation}', '{result}');".format(argument1 = arg1, argument2 = arg2, operation = "get_week_number", result = result)
    plpy.execute(query_string)

    return result
$$ LANGUAGE plpython3u;

CREATE OR REPLACE FUNCTION get_day_of_week (arg1 varchar, arg2 varchar default '0')
  RETURNS varchar
AS $$
    d1 = str(arg1).strip().split(' ')
    d1.reverse()
    d1 = [int(x) for x in d1]
    if not (len(d1) == 3):
        raise ValueError("Dates must be in format day month year e.g. 25 12 2020")
    import datetime
    from dateutil.relativedelta import relativedelta
    d1 = datetime.date(*d1)
    result = d1.strftime('%A')
    query_string = "INSERT INTO date_operations (argument1, argument2, operation, result) VALUES ('{argument1}', '{argument2}', '{operation}', '{result}');".format(argument1 = arg1, argument2 = arg2, operation = "get_day_of_week", result = result)
    plpy.execute(query_string)

    return result
$$ LANGUAGE plpython3u;

CREATE OR REPLACE FUNCTION natural_language_processor (arg1 varchar, arg2 varchar)
  RETURNS varchar
AS $$
    import datetime
    from dateutil.relativedelta import relativedelta
    d1 = datetime.datetime.today()
    ar2 = int(arg2)

    def add_weeks(temp1, temp2):
        return temp1 + relativedelta(days=+(int(temp2)*7))

    def add_days(temp1, temp2):
        return temp1 + relativedelta(days=+int(temp2))

    def add_months(temp1, temp2):
        return temp1 + relativedelta(months=+int(temp2))

    def add_years(temp1, temp2):
        return temp1 + relativedelta(years=+int(temp2))

    smart_converter = {
        'today':add_days(d1,0),
        'yesterday':add_days(d1,-1),
        'day before yesterday':add_days(d1,-2),
        'tomorrow':add_days(d1,1),
        'day after tomorrow':add_days(d1,2),
        'last week':add_weeks(d1,-1),
        'previous week':add_weeks(d1,-1),
        'last month':add_months(d1,-1),
        'last year':add_years(d1,-1),
        'month after':add_months(d1,1),
        'next month':add_months(d1,1),
        'next week':add_weeks(d1,1),
        'next year':add_years(d1,1),
        'weeks from now':add_weeks(d1,ar2),
        'days from now':add_days(d1,ar2),
        'months from now':add_months(d1,ar2),
        'years from now':add_years(d1,ar2),
        'weeks earlier':add_weeks(d1,-ar2),
        'days earlier':add_days(d1,-ar2),
        'months earlier':add_months(d1,-ar2),
        'years earlier':add_years(d1,-ar2),
    }
    if not arg1 in smart_converter.keys():
        result = "Unable to understand the phrase - "+str(arg1)+" !"
        query_string = "INSERT INTO date_operations (argument1, argument2, operation, result) VALUES ('{argument1}', '{argument2}', '{operation}', '{result}');".format(argument1 = arg1, argument2 = arg2, operation = "natural_language_processing", result = result)
        plpy.execute(query_string)
        return result

    result = smart_converter[arg1]
    query_string = "INSERT INTO date_operations (argument1, argument2, operation, result) VALUES ('{argument1}', '{argument2}', '{operation}', '{result}');".format(argument1 = arg1, argument2 = arg2, operation = "natural_language_processing", result = result.strftime("%d %B %Y"))
    plpy.execute(query_string)

    return result.strftime("%d %B %Y")
$$ LANGUAGE plpython3u;

CREATE OR REPLACE FUNCTION perform_operation (operation varchar, arg1 varchar, arg2 varchar default '0')
  RETURNS varchar
AS $$
    import re
    ar1 = str(arg1).strip()
    ar2 = str(arg2).strip()
    op_l = ['add_dates', 'add_days', 'add_months', 'add_weeks', 'add_years', 'get_day_of_week', 'get_week_number', 'natural_language_processor', 'subtract_dates']
    if not operation in op_l:
        return "Operation - "+operation+", is not yet available."
    if operation == 'natural_language_processor' and len(re.findall(r'\b\d+\b', ar1)) > 0:
        ar2 = re.findall(r'\b\d+\b', ar1)[0]
        ar1 = re.sub(r'\d+', '', ar1).strip()
    query_string = "SELECT {to_perform}('{argument1}', '{argument2}');".format(to_perform = operation, argument1 = ar1, argument2 = ar2)
    result = plpy.execute(query_string)

    return result[0][operation]
$$ LANGUAGE plpython3u;
