
import collection.mutable._

// object
object analyzingData01 {

  // main method
  def main(args: Array[String]): Unit = {

    //create list of array string
    var data = List[Array[String]]()

    //open file
    val bufferedSource = scala.io.Source.fromFile("auto-mpg.csv")
    // extract from file in loop
    for (line <- bufferedSource.getLines.drop(1)) {

      // store in value
      val cols = line.split(",", 9).map(_.trim)

      // store in a list
      data = data :+ cols

    }
    //close open file
    bufferedSource.close()


    // method display list
    def ListAll(): Unit = {
      //extract file from the store
      for (i <- data) {

        // print list item for the user
        println(s"${i(0).toDouble}\t ${i(1).toDouble}\t ${i(2).toDouble}\t ${i(3).toDouble}\t ${i(4).toDouble}\t ${i(5).toDouble}\t ${i(6).toDouble}\t ${i(7)}\t ${(i) (8)}")
      }
    }

    // Anonymous function to find Average
    val avgerag_item = () => {


      // create Hashmap to extract the same brand and store the other value together
      val brand_Mpg = new HashMap[String, Set[Double]] with MultiMap[String, Double]
      val brand_Cylinder = new HashMap[String, Set[Double]] with MultiMap[String, Double]
      val brand_Displacement = new HashMap[String, Set[Double]] with MultiMap[String, Double]
      val brand_Horse_Power = new HashMap[String, Set[Double]] with MultiMap[String, Double]
      val brand_Weight = new HashMap[String, Set[Double]] with MultiMap[String, Double]
      val brand_Acceleration = new HashMap[String, Set[Double]] with MultiMap[String, Double]
      val brand_Year = new HashMap[String, Set[Double]] with MultiMap[String, Double]

      // Create Hashmap to extract the same model and store the other value together
      var model_Mpg = new HashMap[String, Set[Double]] with MultiMap[String, Double]
      var model_Cylinder = new HashMap[String, Set[Double]] with MultiMap[String, Double]
      var model_Displacement = new HashMap[String, Set[Double]] with MultiMap[String, Double]
      var model_Horse_Power = new HashMap[String, Set[Double]] with MultiMap[String, Double]
      var model_Weight = new HashMap[String, Set[Double]] with MultiMap[String, Double]
      var model_Acceleration = new HashMap[String, Set[Double]] with MultiMap[String, Double]
      var model_Year = new HashMap[String, Set[Double]] with MultiMap[String, Double]


      // loop to extract from the main store item value
      for (line <- data) {

        // find item and add them or create new
        if (brand_Mpg.contains(line(7)))
          brand_Mpg(line(7)) = brand_Mpg(line(7)) + line(0).toDouble // adding the value to the existing group entity
        else
          brand_Mpg.addBinding(line(7), line(0).toDouble) // creating a new item
        if (brand_Cylinder.contains(line(7)))
          brand_Cylinder(line(7)) = brand_Cylinder(line(7)) + line(1).toDouble // adding the value to the existing group entity
        else
          brand_Cylinder.addBinding(line(7), line(1).toDouble) // creating a new item
        if (brand_Displacement.contains(line(7)))
          brand_Displacement(line(7)) = brand_Displacement(line(7)) + line(2).toDouble // adding the value to the existing group entity
        else
          brand_Displacement.addBinding(line(7), line(2).toDouble) // creating a new item
        if (brand_Horse_Power.contains(line(7)))
          brand_Horse_Power(line(7)) = brand_Horse_Power(line(7)) + line(3).toDouble // adding the value to the existing group entity
        else
          brand_Horse_Power.addBinding(line(7), line(3).toDouble) // creating a new item
        if (brand_Weight.contains(line(7)))
          brand_Weight(line(7)) = brand_Weight(line(7)) + line(4).toDouble // adding the value to the existing group entity
        else
          brand_Weight.addBinding(line(7), line(4).toDouble) // creating a new item
        if (brand_Acceleration.contains(line(7)))
          brand_Acceleration(line(7)) = brand_Acceleration(line(7)) + line(5).toDouble // adding the value to the existing group entity
        else
          brand_Acceleration.addBinding(line(7), line(5).toDouble) // creating a new item
        if (brand_Year.contains(line(7)))
          brand_Year(line(7)) = brand_Year(line(7)) + line(6).toDouble // adding the value to the existing group entity
        else
          brand_Year.addBinding(line(7), line(6).toDouble) // creating a new item

      }
      // Display brand

      println("-->[Brand]\t ")

      // display brand
      for ((k, v) <- brand_Mpg) printf("%s\t", k)
      println("------------------------------------------------------")


      // display each stored model item mpg value
      print("\nMpg:\t")
      for ((k, v) <- brand_Mpg) printf("%.2f\t", v.sum / v.size)
      println("------------------------------------------------------")

      // display each stored model item Cylinder value
      print("\nCylinder:\t")
      for ((k, v) <- brand_Cylinder) printf("\t%.2f\t", v.sum / v.size)
      println("------------------------------------------------------")

      // display each stored model item Displacement value
      print("\nDisplacement:\t")
      for ((k, v) <- brand_Displacement) printf("\t%.2f\t", v.sum / v.size)
      println("------------------------------------------------------")

      // display each stored model item Horsepower value
      print("\nHorsepower:\t")
      for ((k, v) <- brand_Horse_Power) printf("%.2f\t", v.sum / v.size)
      println("------------------------------------------------------")

      // display each stored model item Weight value
      print("\nWeight:\t")
      for ((k, v) <- brand_Weight) printf(" %.2f\t", v.sum / v.size)
      println("------------------------------------------------------")

      // display each stored model item Acceleration value
      print("\nAcceleration:\t")
      for ((k, v) <- brand_Acceleration) printf("%.2f\t", v.sum / v.size)
      println("------------------------------------------------------")

      // display each stored model item Year value
      print("\nYear:\t")
      for ((k, v) <- brand_Year) printf("%.2f\t", v.sum / v.size)
      println("------------------------------------------------------")

      // Another loop to extract the same model and store value together
      for (line2 <- data) {


        if (model_Mpg.contains(line2(8)))
          model_Mpg(line2(8)) = model_Mpg(line2(8)) + line2(0).toDouble // adding the value to the existing group entity
        else
          model_Mpg.addBinding(line2(8), line2(0).toDouble) // creating a new item
        if (model_Cylinder.contains(line2(8)))
          model_Cylinder(line2(8)) = model_Cylinder(line2(8)) + line2(1).toDouble // adding the value to the existing group entity
        else
          model_Cylinder.addBinding(line2(8), line2(1).toDouble) // creating a new item
        if (model_Displacement.contains(line2(8)))
          model_Displacement(line2(8)) = model_Displacement(line2(8)) + line2(2).toDouble // adding the value to the existing group entity
        else
          model_Displacement.addBinding(line2(8), line2(2).toDouble) // creating a new item
        if (model_Horse_Power.contains(line2(8)))
          model_Horse_Power(line2(8)) = model_Horse_Power(line2(8)) + line2(3).toDouble // adding the value to the existing group entity
        else
          model_Horse_Power.addBinding(line2(8), line2(3).toDouble) // creating a new item
        if (model_Weight.contains(line2(8)))
          model_Weight(line2(8)) = model_Weight(line2(8)) + line2(4).toDouble // adding the value to the existing group entity
        else
          model_Weight.addBinding(line2(8), line2(4).toDouble) // creating a new item
        if (model_Acceleration.contains(line2(8)))
          model_Acceleration(line2(8)) = model_Acceleration(line2(8)) + line2(5).toDouble // adding the value to the existing group entity
        else
          model_Acceleration.addBinding(line2(8), line2(5).toDouble) // creating a new item
        if (model_Year.contains(line2(8)))
          model_Year(line2(8)) = model_Year(line2(8)) + line2(6).toDouble // adding the value to the existing group entity
        else
          model_Year.addBinding(line2(8), line2(6).toDouble) // creating a new item


      }
      //display Model
      println("\n-->[Model]\t ")

      // display each stored model
      for ((k, v) <- model_Mpg) printf("%s\t", k)
      println("------------------------------------------------------")

      // display each stored model item mpg value
      print("\nMpg:\t")
      for ((k, v) <- model_Mpg) printf("%.2f\t", v.sum / v.size)
      println("------------------------------------------------------")

      // display each stored model item cylinder value
      print("\nCylinder:\t")
      for ((k, v) <- model_Cylinder) printf("%.2f\t", v.sum / v.size)
      println("------------------------------------------------------")

      // display each stored model item Displacement value
      print("\nDisplacement:\t")
      for ((k, v) <- model_Displacement) printf("%.2f\t", v.sum / v.size)
      println("------------------------------------------------------")

      // display each stored model item Horsepower value
      print("\nHorsepower:\t")
      for ((k, v) <- model_Horse_Power) printf(" %.2f\t", v.sum / v.size)
      println("------------------------------------------------------")

      // display each stored model item weight value
      print("\nWeight:\t")
      for ((k, v) <- model_Weight) printf("%.2f\t", v.sum / v.size)
      println("------------------------------------------------------")

      // display each stored model item Acceleration value
      print("\nAcceleration:\t")
      for ((k, v) <- model_Acceleration) printf("%.2f\t", v.sum / v.size)
      println("------------------------------------------------------")

      // display each stored model item Year value
      print("\nYear:\t")
      for ((k, v) <- model_Year) printf("%.2f\t", v.sum / v.size)
      println("------------------------------------------------------")
    }


    // Anonymous method to create all average
    val averageAll = () => {


      // Display Average
      println("----------------AVERAGE--------------------------- ")

      println(f"mpg:  ${data.map(_ (0).toDouble).sum / data.size}%.2f") //average mpg
      println(f"cylinder:  ${data.map(_ (1).toDouble).sum / data.size}%.2f") // average cylinder
      println(f"displacement: ${data.map(_ (2).toDouble).sum / data.size}%.2f") //average displacement
      println(f"horsepower: ${data.map(_ (3).toDouble).sum / data.size}%.2f") //average horsepower
      println(f"weight: ${data.map(_ (4).toDouble).sum / data.size}%.2f") //average weight
      println(f"acceleration: ${data.map(_ (5).toDouble).sum / data.size}%.2f") //average acceleration
      println(f"year: ${data.map(_ (6).toDouble).sum / data.size}%.2f") //average year

      println("------------------------------------------------------")

    }
    validity   //call validation or user input

    // user input display and validation
    def validity: String = {
      val test = false
      while (!test) {

        // display input prompt for the user
        println("------------------------------------------------------")
        println("Enter your command from given (list, avg_all,avg_item,quit)")

        // user input value
        val input = scala.io.StdIn.readLine().toLowerCase

        // match user input with the choice
        input match {

          // choice 1
          case "list" =>

            //display list of item
            println("mpg\t cylinders\t displacement\t horsepower\t weight\t acceleration\t year\t line(7)\t line2(8)\t ")
            ListAll()  // call list function/method

          //choice 2 display average item
          case "avg_item" => avgerag_item()   // call average item method

          //choice 3 display all average
          case "avg_all" => averageAll()   // call all average method

          // choice 4 exit
          case "quit" => System.exit(0)

          // invalid choice display
          case _ => println("Enter again  ")  // display try again prompt

        }
      }

      // call validaty method
      validity
    }


  }
}


