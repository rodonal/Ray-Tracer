import kotlin.math.sqrt


fun ray_color(r: Ray): Color {

    var t = hit_sphere(Point3(0.0, 0.0, -1.0), 0.5, r)
    if (t > 0.0) {
        var N = unit_vector(r.at(t) - Vec3(0.0, 0.0, -1.0))
        return Color(N.x() + 1, N.y() + 1, N.z() + 1) * 0.5
    }

    var unit_direction = unit_vector(r.direction())
    t = 0.5 * (unit_direction.y() + 1.0)
    return Color(1.0, 1.0, 1.0) * (1.0 - t) + Color(0.5, 0.7, 1.0) * t

}


fun hit_sphere(center: Point3, radius: Double, r: Ray): Double {

    var oc = r.origin() - center
    var a = r.direction().length_squared()
    var half_b = dot(oc, r.direction())
    var c = oc.length_squared() - radius * radius
    var discriminant = half_b * half_b -  a * c
    if (discriminant < 0) {
        return -1.0
    } else {
        return (-half_b - sqrt(discriminant)) / ( a);
    }


}

//Dont forget to out the type everywhere
fun main(args: Array<String>) {
    //Image
    val aspect_ratio = 16.0 / 9.0
    val image_width = 400
    val image_height = (image_width / aspect_ratio).toInt()

    //Camera
    val viewport_height = 2.0
    val viewport_width = aspect_ratio * viewport_height;
    val focal_length = 1.0;
    val origin = Point3(0.0, 0.0, 0.0);
    val horizontal = Vec3(viewport_width, 0.0, 0.0);
    val vertical = Vec3(0.0, viewport_height, 0.0);
    val lower_left_corner = origin - horizontal / 2.0 - vertical / 2.0 - Vec3(0.0, 0.0, focal_length);


    // Render
    print("P3\n")
    print(image_width)
    print(" ")
    println(image_height)
    println(255)

    for (j in image_height - 1 downTo 0) {
        //System.err.println("\rScanlines remaining: ")
        //System.err.print(j)

        for (i in 0..image_width - 1) {

            var u = (i.toDouble()) / (image_width - 1);
            var v = (j.toDouble()) / (image_height - 1);
            var r = Ray(origin, lower_left_corner + horizontal * u + vertical * v - origin);
            var pixel_color = ray_color(r);
            write_color(pixel_color)
        }
    }


}