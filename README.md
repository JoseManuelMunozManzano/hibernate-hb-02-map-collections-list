# HIBERNATE - MAPPING LISTS
This repository holds hibernate code example for mapping lists

In lists the order is important.
We use  @OrderColumn to track element order/position

For ease of development and testing, we'll use auto configuration
<property name="hibernate.hbm2ddl.auto">create</property>
Database tables are dropped first and then created from scratch
Do this only in development/testing!!!