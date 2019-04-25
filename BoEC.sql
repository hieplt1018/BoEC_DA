DROP DATABASE IF EXISTS BoEC2;
CREATE DATABASE BoEC2;
USE BoEC2;

/* ---------------------------   Clothes   -------------------------- */

CREATE TABLE Suits (
  ID             int(10) NOT NULL AUTO_INCREMENT, 
  TypeClother    int(10), 
  Material       varchar(255), 
  Form           varchar(255), 
  ClothesItemsID int(10), 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

CREATE TABLE Casuals (
  ID             int(10) NOT NULL AUTO_INCREMENT, 
  TypeClother    int(10), 
  Trend          varchar(255), 
  ClothesItemsID int(10), 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

CREATE TABLE Sports (
  ID             int(10) NOT NULL AUTO_INCREMENT, 
  TypeClother    int(10), 
  Model          varchar(255), 
  Activity       varchar(255), 
  ClothesItemsID int(10), 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

CREATE TABLE Dress (
  ID             int(10) NOT NULL AUTO_INCREMENT, 
  Type           varchar(255), 
  ClothesItemsID int(10), 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

CREATE TABLE Clothes (
  ID          int(10) NOT NULL,
  ItemID         int(10) NOT NULL, 
  Gender      varchar(10),
  Size        varchar(255), 
  CatergoryID int(10), 
  Company     varchar(255), 
  Country     varchar(255), 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

CREATE TABLE ClothesCatergory (
  ID   int(10) NOT NULL AUTO_INCREMENT, 
  Name varchar(255), 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

/* ------------------------   Electronic   --------------------------- */

CREATE TABLE Refrigerator (
  ID              int(10) NOT NULL AUTO_INCREMENT, 
  ElectronicsID   int(10), 
  DoorHingers     varchar(255), 
  BatteryInclude  bit(1) NOT NULL, 
  Capacity        varchar(255), 
  BatteryRequired bit(1) NOT NULL, 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

CREATE TABLE Camera (
  ID                 int(10) NOT NULL AUTO_INCREMENT, 
  ElectronicsID      int(10), 
  IsoRange           float NOT NULL, 
  MegaPixel          float NOT NULL, 
  WirelessTechnology varchar(255), 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

CREATE TABLE Tivi (
  ID            int(10) NOT NULL AUTO_INCREMENT, 
  ElectronicsID int(10), 
  Resolution    varchar(255), 
  DisplayTech   varchar(255), 
  Hdr           varchar(255), 
  SoundBar      bit(1) NOT NULL, 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

CREATE TABLE Accessories (
  ID            int(10) NOT NULL AUTO_INCREMENT, 
  ElectronicsID int(10), 
  DeviceOr      varchar(255), 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

CREATE TABLE Phone (
  Model                 varchar(255), 
  ScreenSize            float NOT NULL, 
  StorageCapacity       int(10) NOT NULL, 
  RAM                   int(10) NOT NULL, 
  OS                    varchar(255), 
  ID            int(10) NOT NULL AUTO_INCREMENT, 
  ElectronicsID int(10) NOT NULL, 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

CREATE TABLE Computer (
  DisplaySize           float NOT NULL, 
  OS                    varchar(255), 
  SystemMemory          int(10) NOT NULL, 
  ID            int(10) NOT NULL AUTO_INCREMENT, 
  ElectronicsID int(10) NOT NULL, 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

CREATE TABLE Electronics (
  Warranly          varchar(255), 
  Color             varchar(255), 
  Model             varchar(255), 
  Storage           int(10), 
  RAM               int(10), 
  OS                varchar(255), 
  SystemMemmory     int(10), 
  Height            float, 
  LaptopAccessories bit(1), 
  Size              varchar(255), 
  EnergyUse         float,   
  ID                int(10) NOT NULL AUTO_INCREMENT, 
  ItemID         int(10) NOT NULL,
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

/* -------------------------   Book   ---------------------------- */

CREATE TABLE Book (
  Type       varchar(255) NOT NULL,
  Episode    int(10), 
  Quantity       int(10) NOT NULL, 
  Edition        int(10) NOT NULL, 
  PublishedYear  int(10) NOT NULL,   
  ID             int(10) NOT NULL AUTO_INCREMENT, 
  ItemID         int(10) NOT NULL, 
  BookCategoryID int(10) NOT NULL, 
  PublisherID    int(10) NOT NULL,
  AuthorPersonID int(10) NOT NULL,   
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

CREATE TABLE Author (
  ProfileDescription varchar(255), 
  PersonID           int(10) NOT NULL,
  ID                 int(10) NOT NULL AUTO_INCREMENT, 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

/* --------------------------   Item   -------------------------- */

CREATE TABLE Item (
  ID        int(10) NOT NULL AUTO_INCREMENT, 
  StoreID  int(10) NOT NULL, 
  Name          varchar(255), 
  Des           varchar(255), 
  Price         float NOT NULL,
  DiscountID int(10) NOT NULL, 
  Image       varchar(255), 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

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
CREATE TABLE Items (
  ID         int(10) NOT NULL AUTO_INCREMENT, 
  CartID     int(10) NOT NULL, 
  ItemID     int(10) NOT NULL,
  NumberOf   int(5) NOT NULL,
  Cost       float NOT NULL,    
  Desciption varchar(255),      
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

CREATE TABLE Cart (
  ID            int(10) NOT NULL AUTO_INCREMENT, 
  CustomerID    int(10) NOT NULL,
  NumberOfItem  int(10) NOT NULL,
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

CREATE TABLE Orders (
  ID            int(10) NOT NULL AUTO_INCREMENT, 
  CartID     int(10) NOT NULL, 
  OrdersStatus         int(10) NOT NULL, 
  ReceiveDate         date, 
  OrdersAprovingID     int(10) NOT NULL, 
  CardPaymentMethodID int(10) NOT NULL, 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

CREATE TABLE Bill (
  ID             int(10) NOT NULL AUTO_INCREMENT, 
  ShiftTimeID    int(10) NOT NULL, 
  CustomerID     int(10) NOT NULL, 
  BillStatus     int(11) NOT NULL, 
  OrdersID        int(10) NOT NULL, 
  UpdateDate     date, 
  Cost           float NOT NULL, 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

CREATE TABLE CardPaymentMethod (
  CartPaymentType varchar(255) NOT NULL, 
  CartNumber      varchar(255), 
  ExpiredDate     date, 
  Ccv             int(10) NOT NULL, 
  ID              int(10) NOT NULL AUTO_INCREMENT, 
  AddressID       int(10) NOT NULL, 
  WebAccountID    int(10) NOT NULL, 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

CREATE TABLE OrdersAproving (
  ID         int(10) NOT NULL AUTO_INCREMENT, 
  StaffID    int(10) NOT NULL, 
  Status     varchar(255), 
  Reason     varchar(255), 
  UpdateTime date, 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

/* ------------------------- Customer  ----------------------- */

CREATE TABLE Customer (
  Email       varchar(255), 
  Points      int(10) NOT NULL, 
  ID          int(10) NOT NULL AUTO_INCREMENT, 
  PersonID    int(10) NOT NULL,
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

CREATE TABLE CommonCustomer (
  ID         int(10) NOT NULL AUTO_INCREMENT, 
  CustomerID int(10), 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

CREATE TABLE VipCustomer (
  ID          int(10) NOT NULL AUTO_INCREMENT, 
  CustomerID  int(10), 
  Discount    int(10), 
  ExprireDate date, 
  StartDate   date, 
  DiscountID  int(10) NOT NULL, 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

/* ------------------------- Person  ------------------------- */

CREATE TABLE Person (
  ID           int(10) NOT NULL AUTO_INCREMENT, 
  WebAccountID int(10), 
  Gender       int(11) NOT NULL, 
  FullNameID   int(10) NOT NULL, 
  Birthday     date NOT NULL, 
  AddressID    int(10) NOT NULL, 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

CREATE TABLE WebAccount (
  ID           int(10) NOT NULL AUTO_INCREMENT, 
  Username     varchar(255), 
  Password     varchar(255), 
  CreateDate   date,
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

CREATE TABLE FullName (
  ID         int(10) NOT NULL AUTO_INCREMENT, 
  FirstName  varchar(255), 
  MiddleName varchar(255), 
  LastName   varchar(255), 
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
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

CREATE TABLE Position (
  ID          int(10) NOT NULL AUTO_INCREMENT, 
  Names       varchar(255), 
  Description varchar(255), 
  PRIMARY KEY (ID)) CHARACTER SET UTF8;

CREATE TABLE ShiftTime (
  ID         int(10) NOT NULL AUTO_INCREMENT, 
  Day        date NOT NULL, 
  StarTime   time(6) NOT NULL, 
  FinishTime time(6) NOT NULL, 
  StaffID    int(10) NOT NULL, 
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


