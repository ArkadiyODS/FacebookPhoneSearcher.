package Model.FacebookParser;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import java.io.FileWriter;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Facebook { 
        private static final String LOGIN_URL = "https://www.facebook.com/login.php";
	/* ID логин формы. */
	private static final String LOGIN_FORM_ID = "login_form";
	/* Имя e-mail формы. */
	private static final String INPUT_EMAIL_NAME = "email";
	/* Имя password формы. */
	private static final String INPUT_PASSWORD_NAME = "pass";
	/* Имя кнопки "Войти". */
	private static final String INPUT_LOGIN_NAME = "login";
	 /* Путь кнопки отправления логин формы на сервер. */
	private static final String XPATH_LOGIN_BUTTON = "//button[@name='login']";
	 /* Путь формы search.*/
	private static final String XPATH_SEARCH_FORM = "//form";
        /* Имя поля поиска.*/
	private static final String INPUT_SEARCH_NAME = "q";
	 /* Путь кнопки отправления search формы на сервер. */
	private static final String XPATH_SEARCH_BUTTON = "//button[@value='1']";
	 /* Путь к данным имени пользователя. */
	private static final String XPATH_USER_NAME = "//div[@class='_5d-5']";
	 /* Путь к другим данным пользователя. */
	private static final String XPATH_USER_DATA = "//div[@class='_52eh']";
         
        	 
	/* HtmlUnit Веб-клиент. */
	private WebClient webClient; 
        /* HtmlUnit главная страница. */
	private HtmlPage mainPage;  
	
	public Facebook() {
		initWebClient(); 
	}
	
	public void login(String email, String password) {
		try {
			/* Получаем логин форму. */
			HtmlForm loginForm = getForm(LOGIN_URL, LOGIN_FORM_ID);
			if (loginForm != null) {
				/* Заполняем поле email. */
				loginForm.getInputByName(INPUT_EMAIL_NAME).setValueAttribute(email);
				/* Заполняем поле password. */
				loginForm.getInputByName(INPUT_PASSWORD_NAME).setValueAttribute(password);
				/* Нажимаем кнопку "Войти" и получаем страницу, на которую нас перенаправит Facebook. */  
                          HtmlButton button = loginForm.getFirstByXPath(XPATH_LOGIN_BUTTON); 
                          mainPage = button.click();   
                          }
                }catch (Exception e) {
			e.printStackTrace();
		}  
        }
                
        public String searchResultParser(HtmlPage page) {
            try{
                if(page != null) {
                           DomNode name = page.getFirstByXPath("//div[@class='_5d-5']");
                           DomNode city = page.getFirstByXPath("//div[@class='_52eh']");  
                           
                           if(name != null && city != null) { 
                               return name.asText();
                             /*   FileWriter fw = new FileWriter("names.txt",true);
                                fw.write((name.asText() + " " ).toCharArray());
                                fw.write((city.asText() + "\n").toCharArray());  
                                fw.flush();
                                fw.close(); 
                               */
                           }
                }
            } catch (Exception e) {
			e.printStackTrace();
		}
            return null;
        }
        
        public String search(List<String> searchParameters) {
		try {
                    if(mainPage != null) {
                        HtmlForm searchForm = mainPage.getFirstByXPath(XPATH_SEARCH_FORM);
                        if(searchForm != null) {
                            HtmlButton button = searchForm.getFirstByXPath(XPATH_SEARCH_BUTTON);
                            if(button != null) {
                                ExecutorService threadPool = Executors.newCachedThreadPool();
                                for(String searchValue: searchParameters) { 
                                    searchForm.getInputByName(INPUT_SEARCH_NAME).setValueAttribute(searchValue);
                                    /* Активируем поиск и передаем результаты в парсер. */
                                    return searchResultParser(button.click());   
                                }
                            }
                            else throw new Exception("Bad parsing of search form, no send button found!");
			} 
                        else throw new Exception("Bad parsing of page, no search from found!");
                    }
                }
		catch (Exception e) {
			e.printStackTrace();
		}
                return null;
	}
        
        
        public String search(String searchParameter) {
		try {
                    if(mainPage != null) {
                        HtmlForm searchForm = mainPage.getFirstByXPath(XPATH_SEARCH_FORM);
                        if(searchForm != null) {
                            HtmlButton button = searchForm.getFirstByXPath(XPATH_SEARCH_BUTTON);
                            if(button != null) { 
                                    searchForm.getInputByName(INPUT_SEARCH_NAME).setValueAttribute(searchParameter);
                                    /* Активируем поиск и передаем результаты в парсер. */
                                    return searchResultParser(button.click());    
                            }
                            else throw new Exception("Bad parsing of search form, no send button found!");
			} 
                        else throw new Exception("Bad parsing of page, no search from found!");
                    }
                }
		catch (Exception e) {
			e.printStackTrace();
		}
                
                return null;
	}
        
	 
	/**
	 * Инициализируем WebClient.
	 */
	private void initWebClient() {
		webClient = new WebClient(BrowserVersion.BEST_SUPPORTED); 
		/* Отключаем CSS. */
	 	webClient.getOptions().setCssEnabled(false); 
                 
	}
	
	/**
	 * Получаем форму по formID.
	 */
	private HtmlForm getForm(String PageUrl, String formID) {
		HtmlForm form = null; 
		try {
			HtmlPage page = webClient.getPage(PageUrl);
			form = getForm(page, formID);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return form;
	}
	
	/**
	 * Получаем форму по formID со страницы page.
	 */
	private HtmlForm getForm(HtmlPage page, String formID) {
		HtmlForm form = null;
		
		List<HtmlForm> forms = page.getForms();
		
		for (HtmlForm tForm : forms) {
			if (tForm.getId().equalsIgnoreCase(formID)) {
				form = tForm;
				break;
			}
		}
		return form;
	}
	    
}
