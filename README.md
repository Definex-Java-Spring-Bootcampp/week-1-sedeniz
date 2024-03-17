[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/Z1kPkJOi)
# 1.Hafta Ödevi 
1. Java dünyasındaki framework’ler ve çözdükleri problemler nedir? Kod Örneklendirini de içermelidir. `(5 Puan)`
   Java'daki çeşitli frameworklerin her biri yazılım geliştirme süreçlerinde karşılaşılan farklı problemleri çözmeye, süreci hızlandırmaya ve basitleştirmeye yönelik oluşturulmuştur.
   
* **Spring:** Java uygulamalarını daha hızlı, basit ve daha az kod & konfigürasyon işlemi ile geliştirmeye yarayan, open source ve modüler bir yapıda olan framework. Hibernate gibi çeşitli diğer frameworklerin ve modüllerin kullanımını da destekler. Dependency injection, routing, güvenlik ve veri alışverişi gibi bir çok modülü içerir. Spring Boot da Spring framework'ünün üzerine kurulu, kolayca yapılandırılabilen mikroservislerin hızlı bir şekilde geliştirilmesine olanak tanıyan bir librarydir.
  
*  **Hibernate:** Java için bir ORM yani Object Relational Mapping framework'üdür. Nesne tabanlı programlama ile database arasındaki uyuşmazlığı çözer, databse işlemlerini daha nesne yönelimli bir yaklaşımla gerçekleştirilmesine olanak tanır. Aşağıdaki örnek kodda, Hibernate User classını bir database table olarak yönetir.
'''
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
'''

3. SOA - Web Service - Restful Service - HTTP methods kavramlarını örneklerle açıklayınız. `(15 Puan)`
* **SOA (Service Oriented Architecture - Servis Odaklı mimari):** Farklı işlevleri yerine getirmek üzere tasarlanmış bağımsız servislerin bir araya getirilmesiyle oluşturulan bir mimaridir. Bu servisler ağ üzerinden birbirleriyle iletişim kurarak ve birleşerek daha büyük uygulamalar oluşturulur. Bu yaklaşım servislerde modülerlik, esneklik ve yeniden kullanılabilirliği teşvik eder. Örneğin, bir finans şirketi müşteri bilgilerini yönetmek, ödeme işlemlerini gerçekleştirmek ve kredi notu analizi yapmak gibi çeşitli servisler geliştirebilir. Bu servisler, kurumun farklı uygulamalarında tekrar tekrar kullanılabilir. Böylece, yeni bir uygulama geliştirilirken, mevcut servisler yeniden kullanılarak geliştirme süreci hızlandırılmış olur.
* **Web Service:** İnternet üzerinden farklı uygulamaların birbirleriyle iletişim kurmasını sağlayan yazılım yapılarıdır. SOAP ve REST olmak üzere iki ana türü vardır.
* **SOAP (Simple Object Access Protocol):** Güvenli, güvenilir ve standartlaşmış bir iletişim protokolü sunar. XML tabanlı mesajlaşmayı kullanılır. Bir bankacılık uygulamasında, müşterilerin bakiyesini sorgulamak amacıyla bir SOAP web servisi kullanılabilir.
* **RESTful Service:** REST (Representational State Transfer), web servislerini oluşturmak için kullanılan bir mimari stildir. Bu yaklaşım, basitliği ve web temel protokollerini kullanmasıyla geniş çapta uygulanabilirliği ile daha öne çıkar. HTTP protokolünü kullanarak kaynaklara erişim sağlar. Veri alışverişi genellikle JSON formatında gerçekleşir.
* **HTTP Methods:** HTTP, RESTful servislerin temelini oluşturur ve CRUD (Create, Read, Update, Delete) işlemlerini gerçekleştirmek için çeşitli metodlar sunar. En yaygın kullanılan HTTP metodları GET, POST, PUT, DELETE'tir.
   * *GET:* Bir veriyi sunucudan istemek için endpointe GET isteği gönderilir.
   * *POST:* Sunucuda bir veri kaydı oluşturmak için  endpointe POST isteği gönderilir.
   * *PUT:* Sunucudaki bir veriyi güncellemek için endpointe PUT isteği gönderilir.
   * *DELETE:* Sunucudaki bir veri kaydını silmek için  endpointe DELETE isteği gönderilir. Database'den genellikle veri silinmemeye çalışıldığından dolayı DELETE yerine PUT kullanılarak veri kaydının deaktive edilmesi tercih edilebilir.

4. Singleton ve Factory pattern kullanarak projedeki objeleri oluşturun. `(10 Puan)`

5. Aşağıdaki eksiklikleri [**bizimkredi**](https://github.com/Definex-Java-Spring-Bootcampp/kredinbizden-service) projesine ekleyin. `(50 Puan)` 
    * Aynı e-mail adresi ile bir kullanıcı kayıt olabilir.  
    * Kullanıcının şifresi **SHA-512** ile şifrelenerek kullanıcı oluşturulmalıdır.  
    * En çok başvuru yapan kullanıcıyı bulan methodu yazın.  
    * En yüksek kredi isteyen kullanıcıyı ve istediği tutarı bulan methodu yazın.  
    * Son bir aylık yapılan başvuruları listeleyen methodu yazın.  
    * Kampanya sayısı en çoktan aza doğru olacak şekilde kredi kartı tekliflerini listeleyen methodu yazın.  
    * cemdrman@gmail.com mail adresine sahip kullanıcının bütün başvurularını listeleyen methodu yazın.(Parametrik şekilde çalışmalıdır.)  

6. Bir müşteri, ürün, sipariş ve fatura objeleri olacak şekilde online alışveriş sistemi tasarlayın. `(20 PUAN)`
    * Bir müşteri birden fazla sipariş verebilir.
    * Bir sipariş içerisinde birden fazla ürün olabilir.
    * Ürünün kategorisi, fiyatı, ismi ve stok bilgisi vardır.
    * Her siparişin bir faturası vardır.

> Bu kurallar çerçevesinde derste öğrendiğimiz **OOP** kavramlarını ve **Collection Framework** yapılarını örnekleyin.   
> > Sadece derslerde yaptığımız gibi Main method üzerinden gerekli instance oluşturması yapılacaktır ekstra bir yapıya ihtiyaç yoktur. 

* Bu doğrultuda aşağıdaki soruların cevaplarını yazan kodu yazınız.
    - Sistemdeki bütün müşterisi sayısını bulan,  
    - İsmi Cem olan müşterilerin aldıkları ürün sayısını bulan, 
    - İsmi Cem olup yaşı 30’dan küçük 25’ten büyük müşterilerin toplam alışveriş tutarını hesaplayın,
    - Sistemdeki 1500 TL üzerindeki faturaları listeleyin.
---
*Eğitmen - Cem DIRMAN*  
*Kolay Gelsin*  
