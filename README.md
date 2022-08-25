# OiMenu JAVA SDK

## Documentação

Link para a documentação atualizada: [https://developers.oimenu.com.br](https://developers.oimenu.com.br)

## Instalação via Maven

Adicione essa dependencia ao POM do seu projeto:

```xml
<dependency>
  <groupId>br.com.oimenu</groupId>
  <artifactId>oimenu-java</artifactId>
  <version>2.0.3</version>
</dependency>
```

## Instalação Manual

É possível baixar a última versão em [latest release](https://github.com/oimenu/oimenu-java/releases). Para utilizar o OiMenu SDK, inclua o arquivo .jar ao seu projeto.


## Dependências

O OiMenu SDK necessita que as seguintes bibliotecas estejam adicionadas ao seu projeto para funcionar corretamente:

- [`gson`](https://github.com/google/gson)

## Utilizando o SDK

Um exemplo de uso do SDK é:

```java
// definir o token de acesso e URL Base ("https://developers.oimenu.com.br/api/v1" ou "http://IP:PORTA/api/v1")
OimenuClient oimenuClient = new OimenuClient("OIMENU-TOKEN", "OIMENU-BASE-URL");

// listar pedidos pendentes
OrderResult result = oimenuClient.getAllOrders();
if (result.getSuccess()) {
    for (int i = 0; i < result.getData().size(); i++)
	Order order = result.getData().get(i);
} else
    System.out.println(result.getMessage());
}

// cadastrar um produto do ERP
Product product = new Product();
product.setCode("1006");
product.setName("Chopp da Casa 600ml");
product.setPrice(6.50);
product.setExtraFields("{\"any_field\":1}");

if (result.getSuccess()) {
    System.out.println("O produto foi criado com sucesso.");
} else {
    System.out.println(result.getMessage());
}
```
