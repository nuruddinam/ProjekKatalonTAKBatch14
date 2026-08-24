import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.waitForElementVisible(findTestObject('Page_makeAppointment/select_Facility_dropdown'), 30)

WebUI.selectOptionByValue(findTestObject('Page_makeAppointment/select_Facility_dropdown'), facility, true)

//WebUI.click(findTestObject('Page_makeAppointment/readMission_input'))
// User melakukan check Hospital Readmission
if (readmission == true) {
    WebUI.check(findTestObject('Page_makeAppointment/readMission_input'))
} else {
    WebUI.uncheck(findTestObject('Page_makeAppointment/readMission_input'))
}

//WebUI.click(findTestObject('Page_makeAppointment/program_Medicaid_input'))
'User memilih Program Healthcare yang diinginkan'
select_radio = program

switch (select_radio) {
    case 'Medicaid':
        WebUI.check(findTestObject('Page_makeAppointment/program_Medicaid_input'))

        break
    case 'Medicare':
        WebUI.check(findTestObject('Page_makeAppointment/program_Medicare_input'))

        break
    case 'None':
        WebUI.check(findTestObject('Page_makeAppointment/program_None_input'))

        break
    default:
        WebUI.check(findTestObject('Page_MakeAppointment/program_None_input'))

        break
}

WebUI.setText(findTestObject('Page_makeAppointment/VisitDate_input'), visitDate)

WebUI.setText(findTestObject('Page_makeAppointment/Comment_textarea'), comment)

WebUI.click(findTestObject('Page_makeAppointment/bookAppointment_btn'))

WebUI.verifyElementText(findTestObject('Page_appointmentConfirmation/p_Facility'), facility)

WebUI.verifyElementText(findTestObject('Page_appointmentConfirmation/p_visitDate'), visitDate)

WebUI.verifyElementText(findTestObject('Page_appointmentConfirmation/p_Comment'), comment)

if (readmission == true) {
    WebUI.verifyElementText(findTestObject('Page_appointmentConfirmation/p_Readmission'), 'Yes')
} else {
    WebUI.verifyElementText(findTestObject('Page_appointmentConfirmation/p_Readmission'), 'No', FailureHandling.OPTIONAL)
}

select_radio = program

switch (select_radio) {
    case 'Medicaid':
        WebUI.verifyElementText(findTestObject('Page_appointmentConfirmation/p_HealtcareProgram'), program)

        break
    case 'Medicare':
        WebUI.verifyElementText(findTestObject('Page_appointmentConfirmation/p_HealtcareProgram'), program)

        break
    case 'None':
        WebUI.verifyElementText(findTestObject('Page_appointmentConfirmation/p_HealtcareProgram'), program)

        break
    default:
        WebUI.verifyElementText(findTestObject('Page_appointmentConfirmation/p_HealtcareProgram'), 'None')

        break
}

