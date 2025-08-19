async function headerCart()
{
	let resolve = await fetch('headerCart.do?');
	let result = await resolve.json();
}