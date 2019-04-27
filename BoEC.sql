DROP DATABASE IF EXISTS BoEC2;
CREATE DATABASE BoEC2;
USE BoEC2;

/* ---------------------------   Clothes   -------------------------- */

CREATE TABLE Clothes (
  ID          varchar(255) NOT NULL, 
  Name          varchar(255), 
  Des           varchar(255), 
  Price         float NOT NULL,
  DiscountID int(10) NOT NULL, 
  Image       varchar(255), 
  Gender      varchar(10),
  Size        varchar(255), 
  ClothesCatergoryID int(10) NOT NULL, 
  Company     varchar(255), 
  Country     varchar(255), 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

CREATE TABLE ClothesCatergory (
  ID   int(10) NOT NULL AUTO_INCREMENT, 
  Name varchar(255), 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

/* ------------------------   Electronic   --------------------------- */

CREATE TABLE Electronics (
  Warranly          varchar(255), 
  ScreenSize            float NOT NULL, 
  Resolution    varchar(255), 
  DisplayTech   varchar(255), 
  Hdr           varchar(255), 
  SoundBar      bit(1) NOT NULL, 
  Color             varchar(255), 
  Model             varchar(255), 
  Storage           int(10), 
  RAM               int(10), 
  OS                varchar(255), 
  SystemMemory     int(10), 
  Height            float, 
  LaptopAccessories bit(1), 
  DoorHingers     varchar(255), 
  BatteryInclude  bit(1) NOT NULL, 
  Capacity        varchar(255), 
  BatteryRequired bit(1) NOT NULL,
  Size              varchar(255), 
  EnergyUse         float,   
  ID                varchar(255) NOT NULL AUTO_INCREMENT, 
  Name          varchar(255), 
  Des           varchar(255), 
  Price         float NOT NULL,
  DiscountID int(10) NOT NULL, 
  Image       varchar(255), 
  ElectronicCategory int(10) NOT NULL,
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

CREATE TABLE ElectronicCategory (
  ID   int(10) NOT NULL AUTO_INCREMENT, 
  Name varchar(255), 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

/* -------------------------   Book   ---------------------------- */

CREATE TABLE Book (
  Type       varchar(255) NOT NULL,
  Episode    int(10), 
  Quantity       int(10) NOT NULL, 
  Edition        int(10) NOT NULL, 
  PublishedYear  int(10) NOT NULL,   
  ID             varchar(255) NOT NULL AUTO_INCREMENT, 
  Name          varchar(255), 
  Des           varchar(255), 
  Price         float NOT NULL,
  DiscountID int(10) NOT NULL, 
  Image       varchar(255), 
  BookCategoryID int(10) NOT NULL, 
  PublisherID    int(10) NOT NULL,
  Author varchar(255) NOT NULL,   
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

CREATE TABLE BookCategory (
  ID   int(10) NOT NULL AUTO_INCREMENT, 
  Name varchar(255), 
  Type varchar(255), 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

CREATE TABLE Publisher (
  ID        int(10) NOT NULL AUTO_INCREMENT, 
  Name      varchar(255), 
  Email     varchar(255), 
  AddressID int(10) NOT NULL, 
  Phone     varchar(255), 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

/* --------------------------   Item   -------------------------- */

CREATE TABLE Discount (
  ID        int(10) NOT NULL AUTO_INCREMENT, 
  Name      varchar(255), 
  Rate      float NOT NULL, 
  BeginDate date, 
  EndDate   date, 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

CREATE TABLE Store (
  ID        int(10) NOT NULL AUTO_INCREMENT, 
  AddressID int(10) NOT NULL, 
  ListItem  int(10), 
  Name      varchar(255), 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

/*  ----------------   Items:Cart:Orders:Bill   --------------------- */
/* Luư trữ mặt hàng được lưu trong giỏ hàng */  

CREATE TABLE Orders (
  ID            int(10) NOT NULL AUTO_INCREMENT, 
  OrdersStatus         int(10) NOT NULL, 
  ReceiveDate         date, 
  OrdersAprovingID     int(10) NOT NULL, 
  CardPaymentMethodID int(10) NOT NULL, 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

CREATE TABLE Bill (
  ID             int(10) NOT NULL AUTO_INCREMENT, 
  StaffID    int(10) NOT NULL, 
  CustomerID     int(10) NOT NULL, 
  BillStatus     int(11) NOT NULL, 
  OrdersID        int(10) NOT NULL, 
  CreateDate     date, 
  Cost           float NOT NULL, 
  PaymentMethod varchar(255) NOT NULL,
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

CREATE TABLE CardPaymentMethod (
  CartPaymentType varchar(255) NOT NULL, 
  CartNumber      varchar(255), 
  ExpiredDate     date, 
  Ccv             int(10) NOT NULL, 
  ID              int(10) NOT NULL AUTO_INCREMENT, 
  AddressID       int(10), 
  WebAccountID    int(10) NOT NULL, 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

CREATE TABLE Orders_Items (
  ID         int(10) NOT NULL AUTO_INCREMENT, 
  OrderID    int(10) NOT NULL, 
  ItemsID     varchar(255) NOT NULL, 
  NumberOfItems int(10), 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;
/* ------------------------- Customer  ----------------------- */

CREATE TABLE Customer (
  Email       varchar(255), 
  Points      int(10) NOT NULL, 
  ID          int(10) NOT NULL AUTO_INCREMENT, 
  PersonID    int(10) NOT NULL,
  TypeCustomer varchar(255) NOT NULL,
  ExprireDate date, 
  StartDate   date, 
  DiscountID  int(10),
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

/* ------------------------- Person  ------------------------- */

CREATE TABLE Person (
  ID           int(10) NOT NULL AUTO_INCREMENT, 
  WebAccountID int(10), 
  Gender       int(11) NOT NULL, 
  Name   varchar(255) NOT NULL, 
  Birthday     date NOT NULL, 
  AddressID    int(10) NOT NULL, 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

CREATE TABLE WebAccount (
  ID           int(10) NOT NULL AUTO_INCREMENT, 
  Username     varchar(255), 
  Password     varchar(255), 
  CreateDate   date,
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

CREATE TABLE Address (
  ID          int(10) NOT NULL AUTO_INCREMENT, 
  HouseNumber varchar(255), 
  Street      varchar(255), 
  Country     varchar(255), 
  City        varchar(255), 
  Distric     varchar(255), 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

/* ------------------------- Staff  ------------------------- */

CREATE TABLE Staff (
  ID          int(10) NOT NULL AUTO_INCREMENT, 
  PersonID    int(10) NOT NULL, 
  PositionID  int(10) NOT NULL, 
  Department  varchar(255),
  ShiftTimeID int(10) NOT NULL, 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

CREATE TABLE Position (
  ID          int(10) NOT NULL AUTO_INCREMENT, 
  Names       varchar(255), 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

CREATE TABLE ShiftTime (
  ID         int(10) NOT NULL AUTO_INCREMENT, 
  Day        date NOT NULL, 
  StarTime   time(6) NOT NULL, 
  FinishTime time(6) NOT NULL, 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

CREATE TABLE Staff_Salary (
  ID        int(10) NOT NULL AUTO_INCREMENT, 
  StaffID   int(10) NOT NULL, 
  Month     int(10) NOT NULL, 
  WorkHours float NOT NULL, 
  Unit      float NOT NULL, 
  Type      varchar(255), 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

CREATE TABLE Reward (
  ID             int(10) NOT NULL AUTO_INCREMENT, 
  Staff_SalaryID int(10) NOT NULL, 
  Name           varchar(255), 
  Description    varchar(255), 
  BonusMoney     float NOT NULL, 
  Day            date, 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

CREATE TABLE Mistake (
  ID             int(10) NOT NULL AUTO_INCREMENT, 
  Staff_SalaryID int(10) NOT NULL, 
  Name           varchar(255), 
  Reason         varchar(255) , 
  PenaltyMoney   float NOT NULL, 
  Day            date NOT NULL, 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;


