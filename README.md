Project Setup:
=============
  DB ::  
  Using in-memory h2 database no need to configure anything\
        Accessing database\
          URL : localhost:8081/h2-console\
          Username : sa\
          Password : password\

Checkout below URL for ALL API Endpoint:
========================================
  http://localhost:8081/swagger-ui/index.html

Create User Template:
=====================
```javascript
{
        "employee_id": 3,
        "username": "AkashChopra",
        "first_name": "Akashh Chopra",
        "lastname": "Banerjee",
        "email": "ronabhi31@gmail.comm",
        "emp_phone_number": 9563610688,
        "addressDTO": {
            "addressID": 2,
            "street_name": "Dummy Street Name",
            "district": "Kolkata",
            "pincode": 700099,
            "state": " Karnatak",
            "country": "INDIA"
        },
        "laptopDTOS": [
           {
                "laptopId": 2,
                "model_name": "HP Pavilion",
                "specs": "2 GB RAM, 1TB Hard Disk, i12 processor"
          },
			    {
                "laptopId": 3,
                "model_name": "MacBook AIR",
                "specs": "2 GB RAM, 1TB Hard Disk"
          }
      ]
}
```
