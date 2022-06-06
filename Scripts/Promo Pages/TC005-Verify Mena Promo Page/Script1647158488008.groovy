import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
import shahid.Common 

new Common().navigateToShahid(GlobalVariable.MenaPromoPageUrl)

//Verify Main Bar Components
new Common().VerifyPromoPagesMainBarComponents()

//Verify Center Section
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/shahidIcon'), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/centerDescriptionText'), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/joinNowButton'),2)
//		WebUI.click(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/joinNowButton'))
//		WebUI.waitForPageLoad(120)
//		WebUI.back()

WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/seeAvailavlePackagesText'), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/FHDIcon'), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/offlineIcon'), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/noADSIcon'), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/multipleDevicesIcon'), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/cancelAnytimeIcon'), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/safeContentIcon'), 2)

//Verify Shahid Originals Section
WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/ShahidOriginalsSection/shahidIcon'), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/ShahidOriginalsSection/shahidIcon'), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/ShahidOriginalsSection/titleText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/ShahidOriginalsSection/descriptionText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/ShahidOriginalsSection/shahidOriginalsSlider'), 2)
WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/ShahidOriginalsSection/tryShahidVIPButton'), 2)


//Verify Movies Section
WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/MoviesSection/moviesIcon'), 2)
WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/MoviesSection/moviesIcon'), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/MoviesSection/moviesIcon'), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/MoviesSection/moviesDescriptionText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/MoviesSection/moviesImageContainer'), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/MoviesSection/channelsLibraryIcon'), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/MoviesSection/tryShahidVIPButton'),2)

//Verify Junior Section
//		WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/JuniorSection/juniorhowsIcon'), 2)
//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/JuniorSection/juniorhowsIcon'), 2)
//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/JuniorSection/juniorIcon'), 2)
//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/JuniorSection/juniorDescriptionText'), 2)
//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/JuniorSection/parentalControlsIcon'), 2)
//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/JuniorSection/safeContentIcon'), 2)
//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/JuniorSection/channelsLibrary'), 2)
//		WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/JuniorSection/tryShahidVIPButton'),2)


//verify prince mohammad pro leage
//
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/princeMohLeageTitle'),2)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/princeMohLeageDiscription'),2)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/theRedIconLeage'),2)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/fightSportIcon'),2)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/AfcCupIcon'),2)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/AfcCupText'),2)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/MbsIcon'),2)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/joinNowLeageButoon'),2)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/sportsBroughtToYouBySscText'),2)

//Verify TVCannels Section
WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/TVChannelsSection/broadcastIcon'), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/TVChannelsSection/broadcastIcon'), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/TVChannelsSection/channelsPromoDescriptionText'), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/TVChannelsSection/liveBroadcastIcon'), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/TVChannelsSection/channelsSlider'), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/TVChannelsSection/tryShahidVIPButton'),2)

//verify One Subscription-Multiple Devices Section
WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/devicesIcon'), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/devicesIcon'), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/devicesImage'), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/oneSubscriptionTitleText'), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/oneSubscriptionDescriptionText'), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/androidIcon'), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/androidtvIcon'), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/IOSIcon'), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/appleTVIcon'), 2)
WebUI.verifyElementPresent(findTestObject("Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/smartTVIcon"), 2)
WebUI.verifyElementPresent(findTestObject("Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/chromeCastIcon"), 2)
WebUI.verifyElementPresent(findTestObject("Object Repository/PromoPages/MenaPromoPage/OneSubscription-MultipleDevicesSection/airPlayIcon"), 2)

//sport changes table
WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/package/mostPopularRedText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/startingFromText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/shahidOriginalExclusiveText'), 3)

//		//packages
WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/ChooseYourPackageTextPromo'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/ChooseYourPackageTextPromo'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/package/mostPopularRedText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/package/noCommitmentCancelYourSubText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/shahidVipText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/sportOnShahidVipText'), 3)
//
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/sportonShahidVipTextGbox'), 3)
//
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/unlimitedEntertainmentHd'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/unlimitedEnertainmentAndSportHd'), 3)
//WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/packagesSection/unlimitedEntertainmentSportHdGbox'), 3)


// alternative methods
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/ifYouHaveVoucherCode'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/otherPaymentMethodsText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/followingAlternativeMethodsText'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/clickHereOtherPaymentMethods'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/CenterSection/clickHereButtonIfYouHavaVoucherCode'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/ifYouHaveAvoucherCodeIcon'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/otherPaymentMethodsIcon'), 3)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/subscribtionFeesText'), 3)

//		//Verify Other Inquiries Section
WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/otherInquiriesTitleText'), 2)
WebUI.scrollToElement(findTestObject("Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/otherInquiriesTitleText"), 2)
WebUI.scrollToElement(findTestObject("Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/howCanISubscribeInquiryText"),2)
//WebUI.scrollToElement(findTestObject("Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/trialPeriodInquiryText"), 2)
WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/unsubscribeInquiryText'), 2)
WebUI.scrollToElement(findTestObject("Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/allowedDevicesInquiryText"), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/emailIcon'), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/emailDetailsText'), 2)
WebUI.verifyElementPresent(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/whatsappIcon'), 2)
//WebUI.scrollToElement(findTestObject('Object Repository/PromoPages/MenaPromoPage/OtherInquiriesSection/whatsappContactUSText'), 3)

//Verify Footer Elements
new Common().verifyFooter()

