# spring-deadletterqueue-example

On running spring-rabbitmq-producer-application run following rest GET call to popluate the queue.

http://localhost:8080/rabbitmq/producer?licenseType=flex&licenseId=lic001&licenseExpiry=20/08/2019

Once the queue (flex.queue and deadLeter.queue) created run the consumer command to throw exception and move the message to dead letter queue.

