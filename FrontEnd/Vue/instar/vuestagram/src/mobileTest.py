import unittest
import time
from appium import webdriver
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions


class AppTest(unittest.TestCase):
    reportDirectory = 'reports'
    reportFormat = 'xml'
    dc = {}
    testName = 'AppTest'
    driver = None
    
    def setUp(self):
        self.dc['reportDirectory'] = self.reportDirectory
        self.dc['reportFormat'] = self.reportFormat
        self.dc['testName'] = self.testName
        self.dc['udid'] = '2c559e991c1d7ece'
        self.dc['platformName'] = 'android'
        self.driver = webdriver.Remote('http://localhost:4723/wd/hub',self.dc)

# 메일 발신
    def mailSendTest(self):
        self.driver.find_element_by_xpath("xpath=//*[@text='WEHAGO']").click()
        self.driver.find_element_by_xpath("xpath=//*[@class='android.widget.RelativeLayout' and ./*[@text='메일']]").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='fab_mail_add']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='searchView']").click()
        self.driver.execute_script("seetest:client.deviceAction(\"BKSP\")")
        self.driver.execute_script("seetest:client.sendText(\"t\")")
        self.driver.find_element_by_xpath("xpath=(//*[@class='android.widget.ListView']/*/*/*/*[@text='testsw1@wehago.com' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@class='android.view.View']]])[1]").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='mail_send_title_edit']").send_keys('test')
        self.driver.find_element_by_xpath("xpath=//*[@id='mail_send_contents_edit']").send_keys('test')
        self.driver.find_element_by_xpath("xpath=//*[@id='btn_right1']").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='메일목록']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='fab_mail_add']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='mail_send_title_edit']").send_keys('faolTest')
        WebDriverWait(self.driver, 10).until(expected_conditions.presence_of_element_located((By.XPATH,'//*[@id='mail_send_contents_edit']')))
        self.driver.find_element_by_xpath("xpath=//*[@id='mail_send_contents_edit']").send_keys('test')
        self.driver.find_element_by_xpath("xpath=//*[@id='btn_right1']").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='확인']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='searchView']").send_keys('t')
        self.driver.find_element_by_xpath("xpath=(//*[@class='android.widget.ListView']/*/*/*/*[@text='testsw1@wehago.com' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@class='android.view.View']]])[1]").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='btn_right1']").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='메일목록']").click()
        WebDriverWait(self.driver, 10).until(expected_conditions.presence_of_element_located((By.XPATH,'//*[@id='fab_mail_add']')))
        self.driver.find_element_by_xpath("xpath=//*[@id='fab_mail_add']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='iv_attendat_select_button']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='cv_sub_mail_checkbox' and (./preceding-sibling::* | ./following-sibling::*)[@text='문지영 <testsw1@wehago.com>']]").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='cv_sub_mail_checkbox' and (./preceding-sibling::* | ./following-sibling::*)[@text='testsw1@wehago.com']]").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='조직도']").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='연락처']").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='조직도']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='cb_organize_tree_member_select' and (./preceding-sibling::* | ./following-sibling::*)[@id='iv_organize_node_tree_selectbar']]").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='cb_organize_tree_member_select' and (./preceding-sibling::* | ./following-sibling::*)[@id='iv_organize_node_tree_selectbar']]").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='최근이메일']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='cv_sub_mail_checkbox' and (./preceding-sibling::* | ./following-sibling::*)[@text='문지영 <testsw1@wehago.com>']]").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='btn_right1']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='mail_send_title_edit']").send_keys('test3')
        self.driver.find_element_by_xpath("xpath=//*[@class='android.widget.LinearLayout' and ./*[@id='mail_send_contents_edit']]").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='mail_send_contents_edit']").send_keys('test3')
        self.driver.find_element_by_xpath("xpath=//*[@id='btn_right1']").click()
        WebDriverWait(self.driver, 30).until(expected_conditions.presence_of_element_located((By.XPATH,'//*[@text='메일목록']')))
        self.driver.find_element_by_xpath("xpath=//*[@text='메일목록']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='fab_mail_add']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='mail_send_attach_file_button']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='attachment_upload_floating_action_button']").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='사진 또는 동영상 촬영']").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='사진촬영']").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='확인']").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='허용']").click()
        self.driver.find_element_by_xpath("xpath=(//*[@id='NONE']/*/*[@class='GLViewGroup' and ./parent::*[@class='GLViewGroup']])[6]").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='확인']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='attachment_upload_floating_action_button']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='touch_outside']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='btn_left']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='searchView']").send_keys('t')
        self.driver.find_element_by_xpath("xpath=(//*[@class='android.widget.ListView']/*/*/*/*[@text='testsw1@wehago.com' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@class='android.view.View']]])[1]").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='mail_send_title_edit']").send_keys('test2')
        self.driver.find_element_by_xpath("xpath=//*[@id='btn_right1']").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='메일목록']").click()
        WebDriverWait(self.driver, 30).until(expected_conditions.presence_of_element_located((By.XPATH,'//*[@id='fab_mail_add']')))
        self.driver.find_element_by_xpath("xpath=//*[@id='fab_mail_add']").click()
        WebDriverWait(self.driver, 10).until(expected_conditions.presence_of_element_located((By.XPATH,'//*[@id='mail_send_option_title_layout']')))
        self.driver.find_element_by_xpath("xpath=//*[@id='mail_send_option_title_layout']").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='예약전송']").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='16']").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='확인']").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='확인']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='searchView']").send_keys('t')
        self.driver.find_element_by_xpath("xpath=//*[@class='android.widget.RelativeLayout' and ./*[@class='android.widget.LinearLayout' and ./*[@text='첨부파일']]]").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='mail_send_title_edit']").send_keys('test1')
        self.driver.find_element_by_xpath("xpath=//*[@id='btn_right1']").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='메일쓰기']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='btn_left']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='ib_main_toolbar_right']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='design_navigation_view']").click()
        self.driver.press_keycode(3) # home


# 수신확인
    def mailCheckTest(self):
        self.driver.find_element_by_xpath("xpath=//*[@text='WEHAGO']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='iv_icon' and (./preceding-sibling::* | ./following-sibling::*)[@text='메일']]").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='mail_dropdown_sort_icon']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='common_bottom_sheet_item_check' and (./preceding-sibling::* | ./following-sibling::*)[@text='대화형 보기']]").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='mail_dropdown_sort_icon']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='common_bottom_sheet_item_check' and (./preceding-sibling::* | ./following-sibling::*)[@text='시간순 보기']]").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='mail_dropdown_filter_icon']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='common_bottom_sheet_item_check' and (./preceding-sibling::* | ./following-sibling::*)[@text='안읽은메일']]").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='mail_dropdown_filter_icon']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='common_bottom_sheet_item_check' and (./preceding-sibling::* | ./following-sibling::*)[@text='중요메일']]").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='mail_dropdown_filter_icon']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='common_bottom_sheet_item_check' and (./preceding-sibling::* | ./following-sibling::*)[@text='첨부메일']]").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='mail_dropdown_filter_icon']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='common_bottom_sheet_item_check' and (./preceding-sibling::* | ./following-sibling::*)[@text='전체메일']]").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='mail_dropdown_mod_icon']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='mail_main_list_left_checkbox' and (./preceding-sibling::* | ./following-sibling::*)[./*[./*[./*[@text='WEHAGO 메일 09:38']]]]]").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='mail_main_list_left_checkbox' and (./preceding-sibling::* | ./following-sibling::*)[./*[./*[./*[@text='WEHAGO 메일 09:37']]]]]").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='mail_main_list_left_checkbox' and (./preceding-sibling::* | ./following-sibling::*)[./*[./*[./*[@text='WEHAGO 메일 09:36']]]]]").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='mail_main_list_left_checkbox' and (./preceding-sibling::* | ./following-sibling::*)[./*[./*[./*[@text='WEHAGO 메일 09:35']]]]]").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='mail_list_mod_delete_layout']").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='확인']").click()
        WebDriverWait(self.driver, 30).until(expected_conditions.presence_of_element_located((By.XPATH,'//*[@id='btn_left']')))
        self.driver.find_element_by_xpath("xpath=//*[@id='btn_left']").click()
        WebDriverWait(self.driver, 10).until(expected_conditions.presence_of_element_located((By.XPATH,'//*[@id='ib_main_toolbar_right']')))
        self.driver.find_element_by_xpath("xpath=//*[@id='ib_main_toolbar_right']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='btn_draw_close']").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='전체메일함']").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='보낸메일함']").click()
        WebDriverWait(self.driver, 10).until(expected_conditions.presence_of_element_located((By.XPATH,'//*[@id='mail_main_list_right_check' and ./parent::*[./parent::*[(./preceding-sibling::* | ./following-sibling::*)[./*[@text='test1']]]] and (./preceding-sibling::* | ./following-sibling::*)[@text='09:38']]')))
        self.driver.find_element_by_xpath("xpath=//*[@id='mail_main_list_right_check' and ./parent::*[./parent::*[(./preceding-sibling::* | ./following-sibling::*)[./*[@text='test1']]]] and (./preceding-sibling::* | ./following-sibling::*)[@text='09:38']]").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='보낸메일함']").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='전체메일함']").click()
        self.driver.press_keycode(3) # home


## 스팸메일함
    def testUntitled(self):
        self.driver.find_element_by_xpath("xpath=//*[@text='WEHAGO']").click()
        self.driver.find_element_by_xpath("xpath=//*[@class='android.widget.RelativeLayout' and ./*[@text='메일']]").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='ib_main_toolbar_right']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='btn_draw_close']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='mail_dropdown_title_icon']").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='전체메일함']").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='스팸메일함']").click()
        self.driver.find_element_by_xpath("xpath=//*[@class='android.widget.LinearLayout' and ./*[@text='문지영 ']]").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='mail_detail_from_more_button']").click()


### 스팸해제 버그 발견
### 로딩 창에서 다음 화면으로 넘어 가지 않음
        self.driver.find_element_by_xpath("xpath=//*[@text='스팸해제']").click()
        WebDriverWait(self.driver, 30).until(expected_conditions.presence_of_element_located((By.XPATH,'//*[@id='back']')))
        self.driver.find_element_by_xpath("xpath=//*[@id='back']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='mail_detail_from_more_button']").click()
        self.driver.swipe(324, 1878, 324, 1764, 619)
        self.driver.find_element_by_xpath("xpath=//*[@id='touch_outside']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='mail_detail_title_bar_back']").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='스팸메일함']").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='비우기' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@text='스팸메일함']]]").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='확인']").click()
        self.driver.press_keycode(3) # home



## 휴지통
 def mailDeleteTest(self):
        self.driver.find_element_by_xpath("xpath=//*[@text='WEHAGO']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='iv_icon' and (./preceding-sibling::* | ./following-sibling::*)[@text='메일']]").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='전체메일함']").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='비우기' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@text='휴지통']]]").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='확인']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='fab_mail_add']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='searchView']").send_keys('t')
        self.driver.find_element_by_xpath("xpath=(//*[@class='android.widget.ListView']/*/*/*/*[@text='testsw1@wehago.com' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@class='android.view.View']]])[1]").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='mail_send_title_edit']").send_keys('test')
        self.driver.find_element_by_xpath("xpath=//*[@id='btn_right1']").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='메일목록']").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='휴지통']").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='받은메일함']").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='받은메일함']").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='WEHAGO 메일']").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='문지영 ']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='mail_detail_titlebar_delete']").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='확인']").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='WEHAGO 메일']").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='휴지통']").click()
        self.driver.find_element_by_xpath("xpath=//*[@class='android.widget.LinearLayout' and ./*[@text='문지영 ']]").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='mail_detail_from_more_button']").click()
        WebDriverWait(self.driver, 10).until(expected_conditions.presence_of_element_located((By.XPATH,'//*[@text='이사람이 보낸 메일 모두 삭제']')))
        self.driver.find_element_by_xpath("xpath=//*[@text='이사람이 보낸 메일 모두 삭제']").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='확인']").click()
        self.driver.press_keycode(3) # home


## 임시보관함
def mailTempStorageTest(self):
        self.driver.find_element_by_xpath("xpath=//*[@text='WEHAGO']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='iv_icon' and (./preceding-sibling::* | ./following-sibling::*)[@text='메일']]").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='fab_mail_add']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='searchView']").send_keys('t')
        self.driver.find_element_by_xpath("xpath=(//*[@class='android.widget.ListView']/*/*[@id='la_sub_mail_view' and ./*[@class='android.view.View']])[1]").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='mail_send_title_edit']").send_keys('testTmp')
        self.driver.find_element_by_xpath("xpath=//*[@id='btn_left']").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='확인']").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='전체메일함']").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='임시보관함']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='mail_dropdown_filter_icon']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='common_bottom_sheet_item_check' and (./preceding-sibling::* | ./following-sibling::*)[@text='전체메일']]").click()
        self.driver.find_element_by_xpath("xpath=//*[@class='android.widget.LinearLayout' and ./*[@text='testsw1@wehago.com'] and (./preceding-sibling::* | ./following-sibling::*)[./*[@text='09:58']]]").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='mail_send_contents_edit']").send_keys('test')
        self.driver.find_element_by_xpath("xpath=//*[@id='searchView']").click()
        self.driver.execute_script("seetest:client.deviceAction(\"BKSP\")")
        self.driver.execute_script("seetest:client.deviceAction(\"BKSP\")")
        self.driver.execute_script("seetest:client.deviceAction(\"BKSP\")")
        self.driver.execute_script("seetest:client.deviceAction(\"BKSP\")")
        self.driver.execute_script("seetest:client.sendText(\"t\")")
        self.driver.find_element_by_xpath("xpath=(//*[@class='android.widget.ListView']/*/*/*/*[@text='testsw1@wehago.com' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@class='android.view.View']]])[1]").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='btn_right1']").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='메일목록']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='mail_dropdown_mod_icon']").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='mail_main_list_left_checkbox' and (./preceding-sibling::* | ./following-sibling::*)[./*[./*[./*[@text='testsw1@wehago.com']]]]]").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='mail_main_list_left_checkbox' and (./preceding-sibling::* | ./following-sibling::*)[./*[./*[./*[@text='10:58']] and ./*[./*[@text='kso0653@naver.com']]]]]").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='mail_main_list_left_checkbox' and (./preceding-sibling::* | ./following-sibling::*)[./*[./*[./*[@text='18:02']] and ./*[./*[@text='kso0653@naver.com']]]]]").click()
        self.driver.find_element_by_xpath("xpath=//*[@id='mail_list_mod_delete_layout']").click()
        self.driver.find_element_by_xpath("xpath=//*[@text='확인']").click()
        self.driver.press_keycode(3) # home



    def tearDown(self):
        self.driver.quit()
        
    if __name__ == '__main__':
        unittest.main()
