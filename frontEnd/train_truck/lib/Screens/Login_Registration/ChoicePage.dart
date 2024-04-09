import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:train_truck/Screens/Bottom.dart';
import 'package:train_truck/Screens/Maps/Itin%C3%A9raireScreen.dart';
import 'package:train_truck/Screens/Maps/MapScreen.dart';
import 'package:train_truck/Screens/Providers/HeaderWidget.dart';
import 'package:train_truck/Services/UserService.dart';

class ChoicePage extends StatelessWidget {
  const ChoicePage({super.key});

  @override
  Widget build(BuildContext context) {
    var primaryColor=Theme.of(context).primaryColor;
    final height = MediaQuery.of(context).size.height;
    final width = MediaQuery.of(context).size.width;

    return Scaffold(
      body: SingleChildScrollView(
        child: Column(
          children: [
            HeaderWidget(),
            SizedBox(height:100),

            Container(
              height: height/10,
              padding: EdgeInsets.symmetric(vertical: 15,horizontal: 15),
              width: width/1.5,
              decoration:BoxDecoration(
                borderRadius: BorderRadius.circular(15),
                color: primaryColor.withOpacity(0.2)
              ) ,
              child: Row(
                mainAxisAlignment:MainAxisAlignment.center,
                children: [
                  Text("Grand lignes",style: TextStyle(color: Colors.black,fontSize: 20,fontWeight: FontWeight.bold)),

                  IconButton(
                      onPressed: (){
                        Navigator.push(
                          context,
                          MaterialPageRoute(
                              builder: (context) =>   BottomPage()),
                        );


                  }, icon:Icon(Icons.next_plan_rounded,color: primaryColor,size: 40,))
                ],
              ),
            ),
            SizedBox(height:100),
            Container(
              height: height/10,
              padding: EdgeInsets.symmetric(vertical: 15,horizontal: 15),
              width: width/1.5,
              decoration:BoxDecoration(
                  borderRadius: BorderRadius.circular(15),
                  color: primaryColor.withOpacity(0.2)
              ) ,
              child: Row(
                mainAxisAlignment:MainAxisAlignment.center,
                children: [
                  Text("Banlieue Sud",style: TextStyle(color: Colors.black,fontSize: 20,fontWeight: FontWeight.bold)),

                  IconButton(onPressed: (){
                    Navigator.push(
                      context,
                      MaterialPageRoute(
                          builder: (context) =>   BottomPage()),
                    );

                  }, icon:Icon(Icons.next_plan_rounded,color: primaryColor,size: 40,))
                ],
              ),
            ),
            SizedBox(height:100),

            Container(
              height: height/10,
              padding: EdgeInsets.all(15),
              width: width/1.5,
              decoration:BoxDecoration(
                  borderRadius: BorderRadius.circular(15),
                  color: primaryColor.withOpacity(0.2)
              ) ,
              child: Row(
                mainAxisAlignment:MainAxisAlignment.center,
                children: [
                  Container(

                      child: Text("Sahel",style: TextStyle(color: Colors.black,fontSize: 20,fontWeight: FontWeight.bold))),

                  IconButton(onPressed: (){

                    Navigator.push(
                      context,
                      MaterialPageRoute(
                          builder: (context) =>  BottomPage()),
                    );
                  }, icon:Icon(Icons.next_plan_rounded,color: primaryColor,size: 40,))
                ],
              ),
            )

          ],
        ),
      ),
    );
  }
}
