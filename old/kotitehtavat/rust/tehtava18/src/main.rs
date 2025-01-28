fn arg_to_i32(arg: &String) -> i32 {
    match arg.parse::<i32>() {
        Ok(num) => {
            return num;
        }
        Err(_) => {
            println!("Failed to parse argument to i32: {}", arg);
            return 0;
        }
    }
}

fn main() {

    let args: Vec<String> = std::env::args().collect();
    
    if args.len() == 1 {
        return;
    }

    let mut nums: Vec<i32> = Vec::new();
    
    for arg in &args[1..] {
        nums.push(arg_to_i32(arg));
    }

    let sum: i32 = nums.iter().sum();

    println!("{}", sum);

}
