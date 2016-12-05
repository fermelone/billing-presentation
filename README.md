# Billing Service Legacy Modernization

To set the context of the presentation exercise, it is a common legacy modernization example, where we have the need to create an employee portal, and a mobile application, to send Bills to be processed to our Billing Processing System and then have a report of the processing results.

For this we have created a reusable API that is sitting on top of the backend system, allowing the web/mobile development team to interact with it, reducing friction and speeding the time to market of these apps. (as it is REST/JSON vs SOAP/XML)

### The following components are involved

* A Billing System SOAP Service (Backend Legacy System)
* A Billing REST API (On top of the SOAP Service)
* A JMS Queue (ActiveMQ) for reporting purposes

### Approach used

We used a design first approach, hence, we started with the API design contract (RAML), defining our resources, methods, request & response schemas.

After that, we leveraged this API Definition in Anypoint Studio, were we used APIKit to scaffold the RAML and create the necessary flows for our API resource, and implementing it using Reliability combined with Message Filtering EAI patterns, to put a reprocessing strategy approach for failed records in place, along with sending just the successful record results to the reporting solution.

### End result

Implementing this approach we are reducing friction for the web/mobile dev team to develop the employee portal, by decoupling the Billing Legacy System connectivity from its consumers, as well as paving the roads for future projects that might reuse the same Billing API. We also add the concept of governability to our Billing API, being able to apply business rules as well as security on top of our systems.
