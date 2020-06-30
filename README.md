Spring MVC RestAPI with PostgreSQL

* Requirements
  * Maven 3.6.1 or higher
  * Docker 17.05 or higher
  * Docker Compose 1.21 or higher
 
 To run on linux, open the terminal and run the file run.sh
 To run on MSWindows, open the terminal and run the file run.bat
 
Endpoints:

Cadastrar Usuario

Request: ``` POST /login ```

Body: 
```javascript
    {
        "name":"Leonardo",
        "username":"email@test.com",
        "password":"123456"
    }
```  
Response: 
```javascript
    {
        "name":"Leonardo",
        "username":"email@test.com",
    }
```

Logar Usuário

Request: ``` POST /users ```

Body: 
```javascript
    {
       "username":"email@test.com",
       "password":"123456"
    }
```  
Response: 
```javascript
   {
        "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJuYXJkb2FzYWZvbnNvQGdtYWlsLmNvbSIsImV4cCI6MTU5NDM2NDMwM30.scqBbpuT4mJirpRPJ_S2frLRRNvY9Wfe7xJDcXEWeR4KRpLp6yzX9xND6mIzbTz_Ud5_EebDxBrLBOXL1t4VHg"
   }
```

Adicionar Marca
Request: ``` POST /marca ```

Body: 
```javascript
   {
   	"name":"Teste Marca"
   }
```  
Response: 
```javascript
  {
      "id": 1,
      "name": "Teste Marca"
  }
```

Obter Marca
Request: ``` GET /marcas/1 ```
Response: 
```javascript
  {
      "id": 1,
      "name": "Teste Marca"
  }
```

Listar Marcas
Request: ``` GET /marcas ```
Response: 
```javascript
  [
    {
          "id": 1,
          "name": "Teste Marca"
      },
    {
          "id": 2,
          "name": "Teste Marca 2"
    }
  ]
```

Listar Patrimonios Por Marca
Request: ``` GET /marcas/1/patrimonios ```
Response: 
```javascript
  [
     {
         "id":"1",
         "name":"Patrimonio Nome",
         "description":"Patrimonio Descrição",
         "identifier":"123e4567-e89b-12d3-a456-556642440000"
         "marca": {
             "id": 1,
             "name": "Teste Marca"
         }
     },
     {
         "id":"2",
         "name":"Patrimonio Nome 2",
         "description":"Patrimonio Descrição",
         "identifier":"123e4567-e89b-12d3-a456-556642441244"
         "marca": {
             "id": 1,
             "name": "Teste Marca"
         }
     }
  ]
```

Atualizar Marca
Request: ``` PUT /marcas/1 ```

Body: 
```javascript
   {
   	    "id": 1,
        "name": "Novo Nome Marca"
   }
```  
Response: 
```javascript
    {
        "id": 1,
        "name": "Novo Nome Marca"
    }
```

Excluir Marca
Request: ``` DELETE /marcas/1 ```


Adicionar Patrimonio
Request: ``` POST /patrimonios ```

Body: 
```javascript
  {
  	"name":"Patrimonio Nome",
  	"description":"Patrimonio Descrição",
  	"marca": {
  	    "id": 1,
  	    "name": "Teste Marca"
  	}
  }
```  
Response: 
```javascript
    {
        "id":"1",
        "name":"Patrimonio Nome",
        "description":"Patrimonio Descrição",
        "identifier":"123e4567-e89b-12d3-a456-556642440000"
        "marca": {
            "id": 1,
            "name": "Teste Marca"
        }
    }
```

Obter Patrimonio
Request: ``` GET /patrimonios/1 ```
 
Response: 
```javascript
    {
        "id":"1",
        "name":"Patrimonio Nome",
        "description":"Patrimonio Descrição",
        "identifier":"123e4567-e89b-12d3-a456-556642440000"
        "marca": {
            "id": 1,
            "name": "Teste Marca"
        }
    }
```

Listar Patrimonio
Request: ``` GET /patrimonios```
 
Response: 
```javascript
    [
        {
            "id":"1",
            "name":"Patrimonio Nome",
            "description":"Patrimonio Descrição",
            "identifier":"123e4567-e89b-12d3-a456-556642440000"
            "marca": {
                "id": 1,
                "name": "Teste Marca"
            }
        },
        {
            "id":"2",
            "name":"Patrimonio Nome 2",
            "description":"Patrimonio Descrição",
            "identifier":"123e4567-e89b-12d3-a456-556642441244"
            "marca": {
                "id": 1,
                "name": "Teste Marca"
            }
        }
    ]
```

Atualizar Patrimonio
Request: ``` PUT /patrimonios/1 ```

Body: 
```javascript
  {
    "id":"1"
  	"name":"Patrimonio Atualizado",
  	"description":"Patrimonio Descrição Atualizada",
  	"marca": {
  	    "id": 1,
  	    "name": "Teste Marca"
  	}
  }
```  
Response: 
```javascript
    {
        "id":"1",
        "name":"Patrimonio Atualizado",
        "description":"Patrimonio Descrição Atualizada",
        "identifier":"123e4567-e89b-12d3-a456-556642440000"
        "marca": {
            "id": 1,
            "name": "Teste Marca"
        }
    }
```


Excluir Patrimonio
Request: ``` DELETE /patrimonios/1 ```