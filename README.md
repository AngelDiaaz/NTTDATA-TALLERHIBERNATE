# NTTDATA-TALLERHIBERNATE

Elaborar un nuevo proyecto web en base a las siguientes indicaciones:

Sobre el ejercicio del taller 1 se deberá adaptar el modelo para incorporar una nueva tabla Contrato cuya relación será de 1:N con la de clientes. Un cliente podrá tener de cero a varios contratos y un contrato sólo estará asociado a un cliente. El contrato tendrá los siguientes atributos o columnas; identificador numérico, fecha de vigencia, fecha de caducidad, precio mensual y la propia relación con Cliente. La entidad Cliente se actualizará para añadir la relación con Contrato.

Se requiere la implementación del patrón DAO. El patrón DAO definirá los métodos CRUD (insertar, consultar todos, consultar por ID, eliminar, actualizar) para la entidad. Además, la entidad Contrato contará con un método de búsqueda por identificador del Cliente.

Se creará un servicio de gestión de Contratos que consuma el DAO correspondiente. Desde la clase principal se consumirá el servicio haciendo uso de todos los métodos creados.

El mapeo de Hibernate se ha de realizar mediante anotaciones JPA. La configuración se realizará en el fichero hibernate.cfg.xml en caso de no utilizar Spring Boot (que pasaría a ser application.properties).
![image](https://user-images.githubusercontent.com/93326288/203034370-d19d5326-e8d8-45ad-aaae-3e5410466f6d.png)
