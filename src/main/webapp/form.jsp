<html>
<body>
<form method="post" action="/servlet051">
        <div>
            <label for="name">Name</label>
            <input type="text" id="name" name="name"/>
        </div>

        <div>
            <label for="quantity">Quantity</label>
            <input type="number" id="quantity" name="quantity"/>
        </div>
        <div>
            <label for="price">Price</label>
            <input type="number" id="price" name="price" min="0" step="0.01"/>
        </div>
    <button type="submit">add to basket</button>
    <a href="servlet052">zawartość koszyka</a>
</form>
</body>
</html>
