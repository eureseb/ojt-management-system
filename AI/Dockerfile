FROM python:3.12.3

WORKDIR /app

RUN pip install tensorflow
RUN pip install pandas
RUN pip install numpy
RUN pip install Flask
RUN pip install psycopg2

COPY . .

EXPOSE 8010

CMD [ "python", "server.py" ]