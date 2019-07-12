# Сервис приема заявок на оплату 
  POST /requests/ -> создаёт новую заявку на оплату
~~~
payload:
{
"routId": 42,
"datatime": 1562910000
}
~~~
routId - номер маршрута. Целое числовое значение.
datatime - дата и время отправления в формате Unix Timestamp
~~~
responce:
{
"requestId": 33
}
~~~
requestId - уникальный идентификатор заявки

# Сервис проверки статуса заявки
2) GET /request/{requestId}/status -> проверка статуса заявки
requestId - уникальный идентификатор заявки
~~~
responce:
{
"status": DONE
}
~~~
status - текущий статус заявки может быть один из IN_PROGRESS (обрабатывается), ERROR (ошибка), DONE (проведено).

# Процесс проведения оплаты (запускается 1 раз в минуту)
3) POST /payments/ -> проводит оплату заявки
~~~
payload:
{
"routId": 42,
"datatime": 1562910000,
"requestId": 33
}
~~~
~~~
responce:
{
"status": DONE
}
~~~
status - текущий статус заявки может быть один из IN_PROGRESS (обрабатывается), ERROR (ошибка), DONE (проведено).