FROM postgres:latest
RUN apt update && apt install -y python3 python3-pip python3-dev libpq-dev postgresql postgresql-contrib
RUN apt install postgresql-plpython3-12
RUN pip3 install python-dateutil
RUN mkdir code
RUN cd code
WORKDIR /code
USER postgres
EXPOSE 5432
ADD ./code/create_table.sql /code
ADD ./code/init_db.sh /docker-entrypoint-initdb.d
# ADD ./code/create_table.sql /code
# USER postgres
# EXPOSE 5432
# CMD psql -U postgres -a -f init.sql
# CMD psql -U postgres -d datetimecalculatordb -a -f create_table.sql
# VOLUME ["/etc/postgresql", "/var/log/postgresql", "/var/lib/postgresql"]
