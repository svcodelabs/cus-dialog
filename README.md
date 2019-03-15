# cus-dialog

Add following code in project level gradle file

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
Add following code in app level gradle file

	dependencies {
	        implementation 'com.github.svcodelabs:cus-dialog:Tag'
	}

Usage:

  
            val dialog = CusDialog(this).progressDialog()
            dialog.show()
            
            dialog.dismiss()
            
            
             val dialog = CusDialog(this).InfoDialog("Testing",
            "Description", "OK", R.drawable.ic_arrow_forward, object : CallbackDialog {
                override fun onPositiveClick(dialog: Dialog) {
                    showDial2()
                    dialog.dismiss()
                }
                override fun onNegativeClick(dialog: Dialog) {}
            })
        dialog.show()
