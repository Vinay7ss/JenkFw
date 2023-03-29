package Testng;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.CreatingNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInformationPage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateMultipleOrgwithDataProviderTest extends BaseClass {
	
	@Test(dataProvider = "getData")
	public void createMulOrgTest(String Org, String INDUSTRY) {
		String ORGNAME = Org+ jUtil.getRandomNumber();
		HomePage hp = new HomePage(driver);
		hp.clickOrganization();
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickCreateOrg();
		CreatingNewOrganizationPage cn = new CreatingNewOrganizationPage(driver);
		cn.saveOrg(ORGNAME,INDUSTRY);
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String OrgHeader = oip.getOrgname(ORGNAME);
		Assert.assertTrue(OrgHeader.contains(ORGNAME));

	}
	@DataProvider
	public Object[][] getData() throws IOException{
		Object[][] data = eUtil.readfromDataprovider("DP");
		return data;
	}

}
