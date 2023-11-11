/**
 * {domain}
 *
 * - Domain services are located at the domain layer and are encapsulated to accomplish the transformation of operations across entities or value objects in the domain;
 * domain services participate in the implementation process in the same way as entities and value objects.
 * - A domain service combines and encapsulates one or more methods of the same entity, or combines or orchestrates the operations of multiple different entities, and is exposed externally as a domain service. Domain services encapsulate the core business logic.
 * The entity's own behavior is implemented internally in the entity class and upwardly encapsulated and exposed as a domain service.
 * - In order to hide the implementation of business logic in the domain layer,
 * all domain methods and services, etc. must be exposed externally through domain services.
 * -  In order to realize decoupling between aggregations within microservices,
 * cross aggregation domain service calls and cross aggregation data interconnections are prohibited in principle.
 */