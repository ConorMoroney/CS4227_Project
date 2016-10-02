public class paymentInfo{

 private String AccountType;
 private String AccountName;
 private int CardNumber;
 private int CRR;
 private String expireDate;
 

 public paymentInfo(){
 
 }
 
 public paymentInfo(String AccountType,String AccountName,
					int CardNumber,int CRR,String expireDate){
  this.AccountType = AccountType;
  this.AccountName = AccountName;
  this.CardNumber = CardNumber;
  this.CRR = CRR;
  this.expireDate = expireDate;
 }
 }
