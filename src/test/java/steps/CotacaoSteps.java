package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.MainPage;
import pages.PricePage;
import pages.ProductPage;
import pages.SendQuotePage;
import pages.VehiclePage;
import pages.InsurantPage;

import static org.junit.Assert.*;

public class CotacaoSteps {
	private WebDriver driver;
	private MainPage mainPage = null;
	private VehiclePage vehiclePage = null;
	private InsurantPage insurantPage = null;
	private ProductPage productPage = null;
	private PricePage pricePage = null;
	private SendQuotePage sendQuotePage = null;
	
	@Given("que usuario acessa o site sampleapp tricentis")
	public void que_usuario_acessa_o_site_sampleapp_tricentis() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();

		mainPage = new MainPage(driver);
		mainPage.Access();
		assertEquals("undefined Insurance", mainPage.getLoadInsurance());
	}

	@And("preenche o formulario de veiculo")
	public void preenche_o_formulario_de_veiculo() {
		vehiclePage = new VehiclePage(driver);
		
		assertEquals("Enter Vehicle Data", mainPage.getActivePageName());		
		
		vehiclePage
			.setMake(1)
			.setModel(1)
			.setCylindercapacityInput("100")
			.setEngineperformanceInput("100")
			.setDateofmanufactureInput("01/01/2020")
			.setNumberOfSeats(1)
			.setRighthanddriveRadio(1)
			.setNumberofseatsmotorcycle(1)
			.setFuel(1)
			.setPayloadInput("1000")
			.settotalweightInput("1000")
			.setlistpriceInput("100000")
			.setlicenseplatenumberInput("123456")
			.setannualmileageInput("10000");
		
		assertEquals("0", vehiclePage.getCounterLabel());
		
		vehiclePage.nextButtonClick();
		assertNotEquals("Enter Vehicle Data", mainPage.getActivePageName());
	}
	
	@And("preenche o formulario de seguro")
	public void preenche_o_formulario_de_seguro() {
		insurantPage = new InsurantPage(driver);
		
		assertEquals("Enter Insurant Data", mainPage.getActivePageName());
		
		insurantPage
			.setfirstnameInput("John")
			.setlastnameInput("Wick")
			.setbirthdateInput("01/01/1980")
			.setcountrySelect(1)
			.setzipcodeInput("90500000")
			.setoccupationSelect(1)
			.sethobbiesOptions(1)
			.sethobbiesOptions(3);

		assertEquals("0", insurantPage.getCounterLabel());
		
		insurantPage.nextButtonClick();
		assertNotEquals("Enter Insurant Data", mainPage.getActivePageName());		
	}

	@And("preenche o formulario de produto")
	public void preenche_o_formulario_de_produto() {
		productPage = new ProductPage(driver);
		
		assertEquals("Enter Product Data", mainPage.getActivePageName());
		
		productPage
			.setstartdateInput("01/01/2022")
			.setinsurancesumSelect(1)
			.setmeritratingSelect(1)
			.setdamageinsuranceSelect(1)
			.sethobbiesOptions(1)
			.setcourtesycarSelect(1);

		assertEquals("0", productPage.getCounterLabel());
		
		productPage.nextButtonClick();
		assertNotEquals("Enter Product Data", mainPage.getActivePageName());	
	}


	@And("preenche o formulario de preco")
	public void preenche_o_formulario_de_preco() {
		pricePage = new PricePage(driver);
		
		assertEquals("Select Price Option", mainPage.getActivePageName());
		
		pricePage
			.setpriceOptions(1);

		assertEquals("0", pricePage.getCounterLabel());
		
		pricePage.nextButtonClick();
		assertNotEquals("Select Price Option", mainPage.getActivePageName());		
	}

	@And("preenche o formulario de cotacao")
	public void preenche_o_formulario_de_cotacao() {
		sendQuotePage = new SendQuotePage(driver);
		
		assertEquals("Send Quote", mainPage.getActivePageName());
		
		sendQuotePage
			.setemailInput("johnwick@putsbox.com")
			.setusernameInput("johnwick2021")
			.setpasswordInput("jw2021JW")
			.setconfirmpasswordInput("jw2021JW");

		assertEquals("0", sendQuotePage.getCounterLabel());
	}

	@When("clica em Send")
	public void clica_em_Send() {
		assertEquals("Send Quote", mainPage.getActivePageName());
		assertEquals("0", sendQuotePage.getCounterLabel());
		
		sendQuotePage
			.sendButtonClick();
		
		assertTrue(sendQuotePage.hasLoading());		
	}

	@Then("mensagem Sending e-mail success! eh exibida")
	public void mensagem_sending_e_mail_success_eh_exibida() {
		assertEquals("Sending e-mail success!", sendQuotePage.getMessageLabel());
		assertFalse(sendQuotePage.hasLoading());	
		mainPage.Close();
	}
}
