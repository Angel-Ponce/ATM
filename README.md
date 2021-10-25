# ATM 💰
A simple ATM `2.0v` 

## Features ✔
### `General`
- User level (Admin and User)
- Authentication
- Properties management
- Pretty UI/UX
- Database engine

### `Admin level`
- Tickets management ($1, $5, $10, $20, $50, $100, $200) USD
- User Query
- Stats of users
- Update number card
- Update limit of withdrawal
- Add new users
- Actions historial

### `User level`
- Update pin/password
- Withdrawal
- Deposit
- View latest transactions
- View balance information
- Actions historial

## How to use? ⚙

You can get the source code in this repo, or download de `.jar` executable at `store/ATM.jar`

### Know the database management

| Element | Type | Description |
|:----:|:----:|:-----------:|
| database | directory 📂 | Save all type of data in it |
| profiles | direcotry 📂 | Save all pictures of users and admins |
| ticet | table 📊 | Save the tickets information type and size |
| token | table 📊 | Save all tokens |
| admin | table 📊 | Save information of the admins entity |
| admin_update_limit | table 📊 | Save all historial of limits updated |
| admin_register_user | table 📊 | Save all historial of users registered by an admin |
| admin_init_atm | table 📊 | Save all historial of atm init by an admin |
| admin_add_cash | table 📊 | Save all historial of money added to the atm by an admin |
| admin_update_card | table 📊 | Save all historial of card numbers udpated |
| user | table 📊 | Save all information of the user entity |
| user_update_pin | table 📊 |  Save all historial of pin updated |
| transactions | table 📊 | Save information of the users transaction, retreats and deposits |
| propertes | table 📊 | Save information about atm properties |

Scheme 

![image](https://user-images.githubusercontent.com/60164099/138621383-96fd808e-21cd-4eb6-ba3a-7f550574efbc.png)

### Databse engine 🗄️

You can find the `ATM.sql` file to mount the database schema (donwload or copy the sql scripts) [here](https://github.com/Angel-Ponce/ATM/blob/master/ATM.sql).

**Remember that this project run only on localhost environment**

You can configurate the database credentials on `src/Others/Connecter.java` file

We recomend you to use the [SQLServer JDBC Driver](https://docs.microsoft.com/en-us/sql/connect/jdbc/microsoft-jdbc-driver-for-sql-server?view=sql-server-ver15)

### Knowing that, you are ready to use and prove this ATM version

## How to get? 📥

```bash
$ git clone https://github.com/Angel-Ponce/ATM.git 
```

or donwload the [`.jar`](https://github.com/Angel-Ponce/ATM/raw/master/store/ATM.jar) executable

# Addons
We know that creating data to test can be tedious and boring, we are working on a plugin that can optimize this part of the ATM test.

## The [ATMSeeder](https://github.com/Angel-Ponce/ATMSeeder) 🌱

"An easy and amazing plugin to ATM"

## Install 📥

Please, go to [ATMSeeder](https://github.com/Angel-Ponce/ATMSeeder) Repository to install `.jar` plugin, consider taking some time to read the README.md file

## Instructions 🗄 

1. Once installed the `ATMSeeder.jar`, move this jar to the directory that contains the `ATM.jar` compiled
2. Open a terminal in the same direcotry
3. Depending your system operating, run the follow command:
  ```bash
  $ java -jar ATMSeeder.jar
  ```
4. Now, use the cli application to generate your data
5. Test your generated data
6. **Remember, to run the ATMSeeder plugin, make sure your database is absolutely empty
7. You're safe, the ATMSeeder has been update to run over this ATM version

### Feel free to contribuite
### Enjoy

# Authors
[Angel Ponce](https://github.com/Angel-Ponce)

[Samantha Chub](https://github.com/Samantha0510)

# Some captures

| 1 | 2 | 3 |
|---|---|---|
|![image](https://user-images.githubusercontent.com/60164099/131301799-e9e32f09-3c53-431d-8d57-5818e5a04e58.png)|![image](https://user-images.githubusercontent.com/60164099/131301805-211504b8-77f3-4ebc-a229-384a4b2d0f29.png)|![image](https://user-images.githubusercontent.com/60164099/131301817-786ee39a-dae7-4532-9fbb-b15e0cad39fb.png) 

| 4| 5| 6|
|---|---|---|
|![image](https://user-images.githubusercontent.com/60164099/131302071-6aee5aa7-26f1-4c16-a63c-7d9d8912eba9.png)|![image](https://user-images.githubusercontent.com/60164099/131302124-71a2a350-2c56-4a6c-a273-ba3526779b54.png)|![image](https://user-images.githubusercontent.com/60164099/131302155-8de95cf0-22e6-47c6-9677-777cd74a7389.png)|
 


