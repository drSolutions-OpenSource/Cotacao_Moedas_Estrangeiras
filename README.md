<h1 align="center">Cotação do Dólar e do Euro</h1>
<p align="center"><i>Repositório para armazenar as códigos em Java criados para um sistema que busca a última cotação 
de venda do Dólar Americano Comercial, Dólar Americano Turismo e do Euro</i></p>

## Sobre esse Projeto

Foi criado um programa que utiliza o Gson para realizar a conexão em um serviço na web (webservice), fazendo uma 
requisição GET para obter a contação atual das moedas Dólar Americano Comercial, Dólar Americano Turismo e do Euro.
<br/><br/>
A <b>AwesomeAPI - API de Cotações</b>, que foi utilizada, possui mais de 150 moedas, sendo atualizada a cada 30 
segundos, enviando também outras informações como o valor de Compra, Venda, Variação, Porcentagem da Variação, 
Máximo e Mínimo, retornando as informações em JSON ou XML, sendo que a documentação dela está em:
<a href="https://docs.awesomeapi.com.br/api-de-moedas">https://docs.awesomeapi.com.br/api-de-moedas</a>.
<br/><br/>
Para trabalhar com o JSON retornado, utilizou-se o Gson, sendo ela uma é uma biblioteca Java, que pode ser usada 
para converter objetos Java em sua representação JSON, além de poder também pode ser usado para converter uma 
string JSON em um objeto Java equivalente. Gson pode trabalhar com objetos Java arbitrários, incluindo objetos
pré-existentes dos quais não possuímos o código-fonte.
<br/><br/>
Neste sistema, utilizamos o Gson para converter o JSON recebido da API <b>AwesomeAPI - API de Cotações</b> em 
uma classe, com o código:
<pre><code>moeda = gson.fromJson(jsonEmString, Moeda.class);</code></pre>

## Tecnologias Utilizadas
<p display="inline-block">
    <img width="60" src="https://cdn.icon-icons.com/icons2/2415/PNG/512/java_original_wordmark_logo_icon_146459.png" alt="Java"/>
</p>

## Ferramentas de Desenvolvimento
<p display="inline-block">
    <img width="48" src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/IntelliJ_IDEA_Icon.svg/512px-IntelliJ_IDEA_Icon.svg.png" alt="IntelliJ IDEA"/>
</p>

## Assuntos Disponíveis para Consulta
<li>Tipos e variáveis do Java</li>
<li>Consumir webservices com o Java utilizando Gson</li>
<li>Trabalhar com arquivos JSON</li>
<li>Datas API DateTime</li>

## Licença

Copyright 2023 drSolutions - Agência Digital, Licensed under the Apache License, Version 2.0 (the "License"); you may 
not use this file except in compliance with the License. You may obtain a copy of the License at

<a href="http://www.apache.org/licenses/LICENSE-2.0">http://www.apache.org/licenses/LICENSE-2.0</a>

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on 
an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the 
specific language governing permissions and limitations under the License.

## FAQ

**Quem pode utilizar esse software?**

Qualquer pessoa pode utilizar, basta possuir uma estação de trabalho com o Java Development Kit instalado.

**Quem pode contribuir?**

Qualquer desenvolvedor pode contribuir, sendo muito bem-vindo! Caso queira contribuir, veja nosso Código de Conduta 
| [Contributor Covenant Code of Conduct](CODE_OF_CONDUCT.md).

## Referências
<p display="inline-block">
    <a href="https://www.java.com/pt-BR/">Java | Oracle</a><br/>
    <a href="https://www.oracle.com/br/java/technologies/downloads/">Java Development Kit</a><br/>
    <a href="https://openjdk.org/">OpenJDK</a><br/>
    <a href="https://github.com/google/gson/">Gson</a><br/>
    <a href="https://docs.awesomeapi.com.br/api-de-moedas">AwesomeAPI - API de Cotações</a><br/>
</p>

## Autor
<a href="https://www.linkedin.com/in/diegomendesrodrigues/">Diego Mendes Rodrigues</a>