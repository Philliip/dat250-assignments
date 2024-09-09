# DAT250 ASSIGNMENT 2 REPORT
The goal of this assignment was to implement a simple REST API for a Poll app using Spring Boot. The domain model provided was implemented, and a CRUD interface was created for `User`, `Poll`, `VoteOption`, and `Vote` entities.
## Implementation
### Domain Model
During the process of implementation of domain model i had to address some issues connected with identifying resources. `User` model uses `username` attribute as an unique identifier which is not convenient, because for other models i used `UUID` identifiers, so of course it would be better to follow principle with UUID, so the identifiers can be uniformed. 
The aggregations could be addressed better from my side. The main parts are in the `/domain`package. I didn't use the `DomainManager`.

### REST API 
Essential parts are in modules `/dto`, `/service` and `/controllers`. Based on test-driven development approach, i first took test cases from assignment page and wrote them in `test.http` file.
In the process i had minor issues with `DTO`s and `controller`s, it was more just a syntax disagreement. 

## Test scenarios
For testing i used scenarios from an assignment page. Going through every test i assured myself, that those specific test cases are correctly implemented.

## Conclusion
In the end of the day i've managed to implement simple REST API with Spring boot framework. This app has issues that could be addressed, like security, make data persistent. To every API should be available API documentation. One of these concerns were mentioned in the optional task.